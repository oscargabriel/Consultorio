package com.example.Consultorio.entities.medicina;
import jakarta.persistence.*;

@Entity
public class PatologiaConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String Observacion;

//============================================ASOCIACIONES============================================
    /**
     * clave foranea para la sociacion con patologias
     */
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patologias_pk",
        foreignKey = @ForeignKey(name = "fk_PatologiaConsutla_Patologias"))
    Patologias patologia;

    /**
     * clave foranea para la sociacion con consultas
     *//*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consutlas_pk",
            foreignKey = @ForeignKey(name = "fk_PatologiaConsutla_Consultas"))
    Consultas consulta;*/
}
