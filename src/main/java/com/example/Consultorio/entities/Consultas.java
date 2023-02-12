package com.example.Consultorio.entities;
import com.example.Consultorio.entities.medicina.Patologias;
import com.example.Consultorio.entities.personas.Doctores;
import com.example.Consultorio.entities.personas.Pacientes;
import jakarta.persistence.*;

@Entity
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//============================================ASOCIACIONES============================================
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctores_pk",
        foreignKey = @ForeignKey(name = "fk_Consulta_Doctores"))
    Doctores doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pacientes_pk",
            foreignKey = @ForeignKey(name = "fk_Consulta_Pacientes"))
    Pacientes pacientes;*/
}
