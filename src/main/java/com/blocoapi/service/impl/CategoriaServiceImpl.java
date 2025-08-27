package com.blocoapi.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blocoapi.dto.UsuarioLogado;
import com.blocoapi.model.Categoria;
import com.blocoapi.repository.CategoriaRepository;
import com.blocoapi.service.CategoriaService;
import com.blocoapi.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public List<Categoria> todasCategorias(HttpServletRequest request) {
        UsuarioLogado usuarioLogado = usuarioService.dadosUsuarioLogado(request);

        String idUsuario = usuarioLogado.idUsuario();
        UUID uuid = UUID.fromString(idUsuario);
        
        List<Categoria> categorias = categoriaRepository.findAllByUsuario_IdUsuario(uuid);
    
        categorias.sort(Comparator.comparing(Categoria::getFavorita).reversed());

        return categorias;
    }

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        categoria.setFavorita(false);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarPorUUID(String idCategoria) {

        UUID uuid = UUID.fromString(idCategoria);

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(uuid);

        if (!categoriaOptional.isPresent()) {
            throw new RuntimeException("Não foi possivel encontrar essa categoria");
        }
        return categoriaOptional.get();
        
    }

    @Override
    public void deletarCategoria(String idCategoria) {
        UUID uuid = UUID.fromString(idCategoria);

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(uuid);

        if (!categoriaOptional.isPresent()) {
            throw new RuntimeException("Não foi possivel encontrar essa categoria");
        }

        categoriaRepository.deleteById(uuid);
    }

    
    
}
