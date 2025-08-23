package com.blocoapi.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "categoria")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_categoria", updatable = false, nullable = false)
    private UUID idCategoria;
    
    private String titulo;
    private String descricao;
    private Boolean favorita;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
}
