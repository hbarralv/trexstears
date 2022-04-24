package com.trextears.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trextears.model.Orden;
import com.trextears.model.Usuario;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
	List<Orden> findByUsuario (Usuario usuario);
}