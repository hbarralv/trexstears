package com.trextears.service;

import java.util.List;
import java.util.Optional;

import com.trextears.model.Producto;

//Definimos los metodos CRUD

public interface ProductoService {
	
	public Producto save(Producto producto);
	//utilizamos optional porque asi podremos validar si el objeto que obtenemos de la base de datos existe o no. 
	public Optional <Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	public List<Producto> findAll();
}
