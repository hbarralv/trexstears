package com.trextears.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trextears.model.DetalleOrden;
import com.trextears.repository.DetalleOrdenRepository;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{
	
	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;
	
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		//TODO Auto-generated method stub
		return detalleOrdenRepository.save(detalleOrden);
	}

}
