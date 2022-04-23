package com.trextears.service;

import java.util.List;

import com.trextears.model.Orden;

public interface OrdenService {
	List<Orden> findAll();
	Orden save (Orden orden);
	String generarNumeroOrden();
}
