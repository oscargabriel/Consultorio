package com.example.Consultorio.dao;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class UsuariosDAO {

    private Long id;

    private String cedula;


    public UsuariosDAO() {
    }

    public UsuariosDAO(Long id, String cedula) {
        this.id = id;
        this.cedula = cedula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "UsuariosDAO{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
