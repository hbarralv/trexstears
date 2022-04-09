package com.trextears.service;

import java.util.Optional;

import com.trextears.model.Usuario;

public interface UsuarioService {
	Optional<Usuario> findById(Integer id);
}
