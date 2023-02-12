package com.example.Consultorio.entities.medicina;
import com.example.Consultorio.entities.Consultas;
import jakarta.persistence.*;

@Entity
public class TratamientoConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//============================================ASOCIACIONES============================================
    /**
     * clave foranea para la sociacion con tratamiento
     */
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tratamiento_pk",
            foreignKey = @ForeignKey(name = "fk_TratamientoConsutla_Tratamiento"))
    Tratamientos tratamiento;*/

    /**
     * clave foranea para la sociacion con consultas
     */
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consutlas_pk",
            foreignKey = @ForeignKey(name = "fk_TratamientoConsutla_Consultas"))
    Consultas consulta;*/
}
