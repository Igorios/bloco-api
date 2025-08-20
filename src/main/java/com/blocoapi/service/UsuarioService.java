package com.blocoapi.service;

import java.util.List;

import com.blocoapi.model.Usuario;

public interface UsuarioService {
    public Usuario criarUsuario(Usuario usuario);
    public List<Usuario> todosUsuario();
}
