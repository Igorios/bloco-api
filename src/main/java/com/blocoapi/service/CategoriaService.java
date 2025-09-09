package com.blocoapi.service;

import java.util.List;

import com.blocoapi.dto.FavoritarCategoria;
import com.blocoapi.model.Categoria;

import jakarta.servlet.http.HttpServletRequest;

public interface CategoriaService {
    public List<Categoria> todasCategorias(HttpServletRequest request);    
    public Categoria buscarPorUUID(String idCategoria);
    public Categoria criarCategoria(Categoria categoria);
    public Categoria atualizarCategoria(Categoria categoria, String idCategoria);
    public void deletarCategoria(String idCategoria);
    public Categoria favoritar(String idCategoria, FavoritarCategoria favoritarCategoria);
}
