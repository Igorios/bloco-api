package com.blocoapi.model;

import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
}
