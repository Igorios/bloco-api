package com.blocoapi.service.impl;

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

        String idUsuario = usuarioLogado.IdUsuario();
        UUID uuid = UUID.fromString(idUsuario);
        
        return categoriaRepository.findAllByUsuario_IdUsuario(uuid);
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

    
    
}
