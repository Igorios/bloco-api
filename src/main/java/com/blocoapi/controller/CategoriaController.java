package com.blocoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blocoapi.dto.FavoritarCategoria;
import com.blocoapi.model.Categoria;
import com.blocoapi.service.CategoriaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> todasCategorias(HttpServletRequest request) {
        return categoriaService.todasCategorias(request);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criandoCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.criarCategoria(categoria);
        return novaCategoria;
    }

    @GetMapping("/{idCategoria}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria buscarCategoriaPorUUID(@PathVariable String idCategoria) {
        return categoriaService.buscarPorUUID(idCategoria);
    }
    
    @DeleteMapping("/{idCategoria}")
    @ResponseStatus(HttpStatus.OK)  
    public void deletarCategoria(@PathVariable String idCategoria) {
        categoriaService.deletarCategoria(idCategoria);
    }
    
    @PutMapping("/{idCategoria}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria atualizarCategoria(@PathVariable String idCategoria, @RequestBody Categoria categoria) {
        return categoriaService.atualizarCategoria(categoria, idCategoria);
    }
    
    @PatchMapping("/favoritar/{idCategoria}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria favoritarCategoria(@PathVariable String idCategoria, @RequestBody FavoritarCategoria favoritarCategoria) {
        return categoriaService.favoritar(idCategoria, favoritarCategoria);
    }

}
