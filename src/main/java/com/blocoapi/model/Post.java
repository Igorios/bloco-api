package com.blocoapi.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "post")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_post", updatable = false, nullable = false)
    private UUID idPost;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    @Column(name = "data_criada", updatable = false)
    private Date dataCriada;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    @Column(name = "data_atualizada")
    private Date dataAtualizada;

    private Boolean favorita;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
    private Categoria categoria;

    @PrePersist
    public void preCreate() {
        this.dataAtualizada = new Date();
        this.dataCriada = new Date();
        this.favorita = false;
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizada = new Date();
    }

}
