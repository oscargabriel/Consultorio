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

    @Column
    private String nombre;

    @Column
    private String descripcion;

//============================================ASOCIACIONES============================================

}
