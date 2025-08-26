package com.blocoapi.service;

import java.util.List;

import com.blocoapi.model.Categoria;

import jakarta.servlet.http.HttpServletRequest;

public interface CategoriaService {
    public List<Categoria> todasCategorias(HttpServletRequest request);    
    public Categoria buscarPorUUID(String idCategoria);
    public Categoria criarCategoria(Categoria categoria);
    public void deletarCategoria(String idCategoria);
}
