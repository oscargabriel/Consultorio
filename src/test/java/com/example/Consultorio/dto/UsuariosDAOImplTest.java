package com.example.Consultorio.dto;

import com.example.Consultorio.entities.personas.Usuarios;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuariosDAOImplTest {



    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
        UsuariosDAO dao = new UsuariosDAOImpl();
        List<Usuarios> usuarios = dao.findAll();
        System.out.println(usuarios.size());

    }
}