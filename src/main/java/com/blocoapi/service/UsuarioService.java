package com.blocoapi.service;

import java.util.List;

import com.blocoapi.dto.UsuarioLogado;
import com.blocoapi.model.Usuario;

import jakarta.servlet.http.HttpServletRequest;

public interface UsuarioService {
    public Usuario criarUsuario(Usuario usuario);
    public List<Usuario> todosUsuario();
    public UsuarioLogado dadosUsuarioLogado(HttpServletRequest request);
}
