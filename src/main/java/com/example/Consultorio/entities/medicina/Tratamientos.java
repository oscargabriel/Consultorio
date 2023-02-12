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

    @Column
    private String nombre;

    @Column
    private String descripcion;

//============================================ASOCIACIONES============================================
}
