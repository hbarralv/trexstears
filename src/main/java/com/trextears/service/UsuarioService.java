package com.trextears.service;

import java.util.List;
import java.util.Optional;

import com.trextears.model.Usuario;

public interface UsuarioService {
	List<Usuario> findAll();
	Optional<Usuario> findById(Integer id);
	Usuario save (Usuario usuario);
	Optional<Usuario> findByEmail(String email);
}
