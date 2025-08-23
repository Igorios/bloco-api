package com.blocoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blocoapi.model.Role.Role;
import com.blocoapi.service.RoleService;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Role> todasRoles() {
        return roleService.todasRoles();
    }

}
