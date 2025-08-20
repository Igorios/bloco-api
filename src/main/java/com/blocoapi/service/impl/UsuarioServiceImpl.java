package com.blocoapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blocoapi.model.Usuario;
import com.blocoapi.repository.UsuarioRepository;
import com.blocoapi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {

        Optional<Usuario> existeUsuario = usuarioRepository.findByEmail(usuario.getEmail());

        if (existeUsuario.isPresent()) {
            throw new IllegalArgumentException("Email ja existe!");
        }

        usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
        Usuario criandoUsuario = usuarioRepository.save(usuario);

        return criandoUsuario;

    }

    @Override
    public List<Usuario> todosUsuario() {
        return usuarioRepository.findAll();
    }
    
}
