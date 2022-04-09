package com.trextears.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trextears.model.DetalleOrden;
import com.trextears.model.Orden;
import com.trextears.model.Producto;
import com.trextears.model.Usuario;
import com.trextears.service.ProductoService;
import com.trextears.service.UsuarioService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductoService productoService;
	@Autowired
	private UsuarioService usuarioService;
	
	//Con este comando almacenaremos los detalles de la orden
	List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();
	
	//Este objeto almacenará los datos de la orden
	Orden orden = new Orden();
	
	
	@GetMapping("")
	public String home(Model model) {		
		model.addAttribute("productos", productoService.findAll());
		return "usuario/home";
	}
	
	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("Id producto: {}", id);
		Producto producto = new Producto();
		Optional<Producto> productoOptional= productoService.get(id);
		producto = productoOptional.get();
		model.addAttribute("producto", producto);
		return"usuario/productohome";
	}
	
	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal=0;
		
		Optional<Producto> optionalProducto = productoService.get(id);
		producto=optionalProducto.get();
		
		detalleOrden.setCantidad(cantidad);
		detalleOrden.setPrecio(producto.getPrecio());
		detalleOrden.setNombre(producto.getNombre());
		detalleOrden.setTotal(producto.getPrecio()*cantidad);
		detalleOrden.setProducto(producto);	
		//Comprobaremos si el producto ya esta añadido
		Integer idProducto=producto.getId();
		//Se realiza la funcion for pero utilizando la API de Java 8
		boolean ingresado=detalles.stream().anyMatch(p -> p.getProducto().getId()==idProducto);	
		if (!ingresado) {
			detalles.add(detalleOrden);
		}	
		sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		return "usuario/carrito";
	}
	
	
	//esta funcion eliminará un producto del carro
	@GetMapping("/delete/cart/{id}")
	public String DeteleProductoCart(@PathVariable Integer id, Model model) {
		
		List<DetalleOrden> ordenesNuevas= new ArrayList<DetalleOrden>();
		for(DetalleOrden detalleOrden: detalles) {
			if (detalleOrden.getProducto().getId()!=id){
				ordenesNuevas.add(detalleOrden);
			}
		}
		//Esta sera la nueva lista con los productos restantes
		detalles=ordenesNuevas;
		double sumaTotal=0;
		sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		
		return "usuario/carrito";
	}
	
	
	@GetMapping("/getCart")
	public String getCart(Model model) {
		
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		return "/usuario/carrito";
	}
	
	@GetMapping("/order")public String order(Model model) {
		//Se añade la ID de usuario directamente ya que todavia no se encuentra implementado el log/reg ni las seguridades
		Usuario usuario = usuarioService.findById(1).get();
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("usuario", usuario);
		return"usuario/resumenorden";
	}
	
	
}