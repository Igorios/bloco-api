package com.blocoapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blocoapi.model.Role.Role;

public interface RoleRepository extends JpaRepository<Role, UUID>{

} 
