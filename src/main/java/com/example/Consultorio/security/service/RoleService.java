package com.example.Consultorio.security.service;


import com.example.Consultorio.entities.Role;

public interface RoleService {
    Role findByName(String name);
}
