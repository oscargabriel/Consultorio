package com.example.Consultorio.entities.personas;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * personal medico
 */
@Entity
public class Doctores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String MPPS;

    @Column(nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(nullable = false)
    private LocalDateTime fechaGraduacion;

    @Column(length = 50, nullable = false)
    private String especializacion;

//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_Usuarios_Doctores"))
    private Usuarios usuario;

    public Doctores(Long id, String MPPS, LocalDateTime fechaIngreso, LocalDateTime fechaGraduacion, String especializacion) {
        this.id = id;
        this.MPPS = MPPS;
        this.fechaIngreso = fechaIngreso;
        this.fechaGraduacion = fechaGraduacion;
        this.especializacion = especializacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMPPS() {
        return MPPS;
    }

    public void setMPPS(String MPPS) {
        this.MPPS = MPPS;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(LocalDateTime fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
