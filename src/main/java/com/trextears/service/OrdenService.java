package com.trextears.service;

import java.util.List;
import java.util.Optional;

import com.trextears.model.Orden;
import com.trextears.model.Usuario;

public interface OrdenService {
	List<Orden> findAll();
	Optional<Orden> findById(Integer id);
	Orden save (Orden orden);
	String generarNumeroOrden();
	List<Orden> findByUsuario (Usuario usuario);
}
