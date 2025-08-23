package com.blocoapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blocoapi.model.Role.Role;
import com.blocoapi.repository.RoleRepository;
import com.blocoapi.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> todasRoles() {
        return roleRepository.findAll();
    }
    
}
