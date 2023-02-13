package com.example.Consultorio.entities.medicina;
import jakarta.persistence.*;

/**
 * listas de tratamientos para las consultas
 */
@Entity
public class Tratamientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

//============================================ASOCIACIONES============================================
}
