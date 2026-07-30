package com.blocoapi.service;

import java.util.List;

import com.blocoapi.model.Role.Role;

public interface RoleService {
    public List<Role> todasRoles();
    public Role criarRole(Role role);
}
