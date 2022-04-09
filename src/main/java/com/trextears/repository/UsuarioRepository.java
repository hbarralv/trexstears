package com.trextears.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trextears.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{

}
