package com.blocoapi.model.Role;

import java.util.List;

import com.blocoapi.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "role")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private Long idRole;

    private String nome;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Usuario> usuarios;

}
