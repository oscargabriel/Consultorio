package com.example.Consultorio.entities;

import jakarta.persistence.*;

import java.util.Set;

/**
 * clase rol se usa para los permisos para las solicitudes http
 */
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    private String nombre;

    @Column(length = 50, unique = true, nullable = false)
    private String descripcion;

//============================================ASOCIACIONES============================================

}
