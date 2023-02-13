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
    Usuarios usuario;
}
