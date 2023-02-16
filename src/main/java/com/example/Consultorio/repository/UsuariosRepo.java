package com.example.Consultorio.repository;

import com.example.Consultorio.dao.UsuariosDAO;
import com.example.Consultorio.entities.personas.Usuarios;

import java.util.List;

public interface UsuariosRepo {

    /**
     * Recuperar todos los usuarios de base de datos de la tabla usuarios
     * Utiliza HQL
     * @return lista de usuarios
     */
    List<Usuarios> findAll();

    Usuarios findByUsername(String username);


}
