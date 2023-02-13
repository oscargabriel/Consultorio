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
}
