package com.example.Consultorio.entities.personas;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * secretaria puede ver hacer consultas y ver todas las consultas
 */
@Entity
public class Secretarias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, scale = 2)
    private Float salario;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_retiro", nullable = true)
    private LocalDateTime fechaRetiro;

//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_Usuarios_Secretaria"))
    Usuarios usuario;
}
