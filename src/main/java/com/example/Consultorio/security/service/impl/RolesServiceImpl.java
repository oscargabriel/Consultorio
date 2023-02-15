package com.example.Consultorio.security.service.impl;

import com.example.Consultorio.entities.Roles;
import com.example.Consultorio.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RolesServiceImpl implements com.example.Consultorio.security.service.RolesService {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Roles findByname(String name) {
        return roleRepository.findRoleByNombre(name);
    }
}
