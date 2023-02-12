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

    @Column
    private String MPPS;

    @Column
    private LocalDateTime fechaIngreso;

    @Column
    private LocalDateTime fechaGraduacion;

    @Column
    private String especializacion;

//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_Usuarios_Doctores"))
    Usuarios usuario;
}
