package com.example.Consultorio.entities.personas;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * secretaria puede ver hacer consultas y ver todas las consultas
 */
@Entity
public class Secretarias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, scale = 2)
    private Float salario;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_retiro", nullable = true)
    private LocalDateTime fechaRetiro;

//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_Usuarios_Secretaria"))
    private Usuarios usuario;

    public Secretarias() {
    }

    public Secretarias(Long id, Float salario, LocalDateTime fechaIngreso, LocalDateTime fechaRetiro, Usuarios usuario) {
        this.id = id;
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
