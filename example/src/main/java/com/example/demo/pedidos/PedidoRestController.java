// package com.example.demo.pedidos;

// import java.util.List;

// import com.example.demo.pedidos.Pedido;
// import com.example.demo.pedidos.PedidoRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;


// @RestController
// @RequestMapping("/pedido")
// public class PedidoRestController {

//     @Autowired
//     private PedidoRepository pedidoRepository;

//     @RequestMapping(method = RequestMethod.GET)
//     public List<Pedido> findAll() {
//         return pedidoRepository.findAll();
//     }
    
// 	@RequestMapping(method = RequestMethod.GET, value = "/{pedidoId}")
//     public Pedido findOne(@PathVariable Long pedidoId) {
//         return pedidoRepository.findOne(pedidoId);
//     }
    
// 	@RequestMapping(method = RequestMethod.POST)
//     public Pedido add(@RequestBody Pedido pedido) {
//         return pedidoRepository.save(pedido);
//     }

// 	@RequestMapping(method = RequestMethod.PUT)
//     public Pedido update(@RequestBody Pedido pedido) {
//         return pedidoRepository.save(pedido);
//     }
	
// 	@RequestMapping(method = RequestMethod.DELETE, value = "/{pedidoId}")
//     public void delete(@PathVariable Long pedidoId) {
//         pedidoRepository.delete(pedidoId);
//     }
	
// }

