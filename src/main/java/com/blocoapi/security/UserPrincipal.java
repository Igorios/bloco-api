package com.blocoapi.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blocoapi.model.Usuario;

import lombok.Getter;

@Getter
public class UserPrincipal implements UserDetails {

    private Long idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private UserPrincipal(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.password = usuario.getPassword();

        this.authorities = usuario.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority("ROLE_".concat(role.getNome()));
        }).collect(Collectors.toList());
    
    }

    public static UserPrincipal create(Usuario usuario) {
        return new UserPrincipal(usuario);
    }

    @Override
    public String getUsername() {
        return email;
    }
    
}
