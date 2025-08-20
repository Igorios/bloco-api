package com.blocoapi.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blocoapi.model.Role.Role;
import com.blocoapi.repository.RoleRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.count() == 0) {
            Role role = new Role();
            role.setNome("administrador");
            roleRepository.save(role);
        }
        
    }
    
    
}
