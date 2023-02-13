package com.example.Consultorio.entities.medicina;
import jakarta.persistence.*;

/**
 * lista de patologias para la union con las consultas
 */
@Entity
public class Patologias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

//============================================ASOCIACIONES============================================

}
