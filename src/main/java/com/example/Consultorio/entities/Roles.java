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

    public Roles() {
    }

    public Roles(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
