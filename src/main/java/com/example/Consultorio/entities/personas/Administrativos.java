package com.example.Consultorio.entities.personas;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * personal administrativo
 */
@Entity
public class Administrativos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String funcion;

    @Column(nullable = false, scale = 2)
    private Float salario;

    @Column(name = "fecha_ingreso",nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_retiro", nullable = true)
    private LocalDateTime fechaRetiro;

//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
            foreignKey = @ForeignKey(name = "fk_Usuarios_Administrativos"))
    private Usuarios usuario;

    public Administrativos() {
    }

    public Administrativos(Long id, String funcion, Float salario, LocalDateTime fechaIngreso, LocalDateTime fechaRetiro, Usuarios usuario) {
        this.id = id;
        this.funcion = funcion;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDateTime fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
