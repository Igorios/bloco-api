package com.blocoapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.blocoapi.dto.UsuarioLogado;
import com.blocoapi.model.Usuario;
import com.blocoapi.repository.UsuarioRepository;
import com.blocoapi.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

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

    @Override
    public UsuarioLogado dadosUsuarioLogado(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        String idUsuario = "";
        String email = "";
        String sobrenome = "";
        List<String> roles = new ArrayList<>();

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            Algorithm algorithm = Algorithm.HMAC256("blog@sistema".getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            idUsuario = decodedJWT.getClaim("idUsuario").asString();
            email = decodedJWT.getClaim("email").asString();
            sobrenome = decodedJWT.getClaim("sobrenome").asString();
            roles = decodedJWT.getClaim("roles").asList(String.class);

        }

        UsuarioLogado usuarioLogado = new UsuarioLogado(idUsuario, email, sobrenome, roles);
        return usuarioLogado;
        
    }
    
}
