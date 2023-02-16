package com.example.Consultorio.repository;

import com.example.Consultorio.entities.personas.Usuarios;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuariosDAOImplTest {
    UsuariosDAO dao;


    @BeforeEach
    void setUp() {
        dao = new UsuariosDAOImpl();
    }

    @Test
    void findAll() {
        List<Usuarios> usuarios = dao.findAll();
        System.out.println(usuarios.size());
        assertNotEquals(null, usuarios);
    }

    @Test
    void findByUsername() {
    }
}