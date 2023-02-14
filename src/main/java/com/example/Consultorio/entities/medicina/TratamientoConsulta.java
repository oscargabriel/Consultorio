package com.example.Consultorio.entities.medicina;
import com.example.Consultorio.entities.Consultas;
import jakarta.persistence.*;

/**
 * clase asosiativa entre consulta y tratamiento con observaciones del doctor
 */

@Entity
@Table(name = "tratamiento_consulta")
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
    private Tratamientos tratamiento;

    /**
     * clave foranea para la sociacion con consultas
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consulta_id",
            foreignKey = @ForeignKey(name = "fk_TratamientoConsulta_Consultas"))
    private Consultas consulta;


    public TratamientoConsulta() {
    }

    public TratamientoConsulta(Long id, String observacion) {
        this.id = id;
        Observacion = observacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public Tratamientos getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamientos tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Consultas getConsulta() {
        return consulta;
    }

    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }
}
