package com.blocoapi.dto;

import java.util.List;

public record UsuarioLogado(
    String IdUsuario,
    String email,
    String sobrenome,
    List<String> roles
) {
    
}
