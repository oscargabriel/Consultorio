package com.example.Consultorio.entities;
import com.example.Consultorio.entities.medicina.Patologias;
import com.example.Consultorio.entities.personas.Doctores;
import com.example.Consultorio.entities.personas.Pacientes;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * consulta
 */

@Entity
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaInicial;

    @Column(nullable = false)
    private LocalDateTime fechaActual;

    @Column(nullable = true, scale = 2)
    private Double costo;

    @Column(nullable = true)
    private LocalDateTime proximaConsulta;


//============================================ASOCIACIONES============================================
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id",
        foreignKey = @ForeignKey(name = "fk_Consultas_Doctores"))
    Doctores doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id",
            foreignKey = @ForeignKey(name = "fk_Consultas_Pacientes"))
    Pacientes pacientes;

    public Consultas() {
    }

    public Consultas(Long id, LocalDateTime fechaInicial, LocalDateTime fechaActual, Double costo, LocalDateTime proximaConsulta) {
        this.id = id;
        this.fechaInicial = fechaInicial;
        this.fechaActual = fechaActual;
        this.costo = costo;
        this.proximaConsulta = proximaConsulta;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDateTime getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDateTime fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public LocalDateTime getProximaConsulta() {
        return proximaConsulta;
    }

    public void setProximaConsulta(LocalDateTime proximaConsulta) {
        this.proximaConsulta = proximaConsulta;
    }

    public Doctores getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctores doctor) {
        this.doctor = doctor;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }
}
