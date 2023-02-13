package com.example.Consultorio.entities.medicina;
import com.example.Consultorio.entities.Consultas;
import jakarta.persistence.*;

/**
 * clase asosiativa entre consulta y tratamiento con observaciones del doctor
 */

@Entity
public class TratamientoConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String Observacion;

//============================================ASOCIACIONES============================================
    /**
     * clave foranea para la sociacion con tratamiento
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tratamiento_id",
            foreignKey = @ForeignKey(name = "fk_TratamientoConsulta_Tratamiento"))
    Tratamientos tratamiento;

    /**
     * clave foranea para la sociacion con consultas
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consulta_id",
            foreignKey = @ForeignKey(name = "fk_TratamientoConsulta_Consultas"))
    Consultas consulta;
}
