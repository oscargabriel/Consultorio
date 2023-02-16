package com.example.Consultorio.repository;

import com.example.Consultorio.dao.UsuariosDAO;
import com.example.Consultorio.entities.personas.Usuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuariosDAOImplTest {
    UsuariosRepo dao;


    @BeforeEach
    void setUp() {
        dao = new UsuariosRepoImpl();
    }

    @Test
    void findAll() {
        List<Usuarios> usuarios = dao.findAll();
        assertNotEquals(null, usuarios);
    }

    @Test
    void findByUsername() {
    }
}