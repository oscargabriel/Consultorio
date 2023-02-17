package com.example.Consultorio.security.service.impl;

import com.example.Consultorio.entities.Role;
import com.example.Consultorio.repository.RoleRepository;
import com.example.Consultorio.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
