package com.example.Consultorio.security.service;

import com.example.Consultorio.entities.Roles;

public interface RolesService {

    Roles findByname(String name);
}
