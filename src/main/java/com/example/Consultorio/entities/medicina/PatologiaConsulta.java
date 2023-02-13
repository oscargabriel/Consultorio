package com.example.Consultorio.entities.medicina;
import com.example.Consultorio.entities.Consultas;
import jakarta.persistence.*;

/**
 * clase asosiativa entre consulta y patologia con observaciones del doctor
 */
@Entity
//@Table(name = "patologia_consulta")
public class PatologiaConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String Observacion;

//============================================ASOCIACIONES============================================
    /**
     * clave foranea para la sociacion con patologias
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patologias_id",
        foreignKey = @ForeignKey(name = "fk_PatologiaConsutla_Patologias"))
    Patologias patologia;

    /**
     * clave foranea para la sociacion con consultas
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consutlas_id",
            foreignKey = @ForeignKey(name = "fk_PatologiaConsutla_Consultas"))
    Consultas consulta;
}
