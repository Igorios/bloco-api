package com.blocoapi.dto;

import java.util.List;

public record UsuarioLogado(
    String idUsuario,
    String email,
    String sobrenome,
    List<String> roles
) {
    
}
