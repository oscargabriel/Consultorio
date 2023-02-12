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

    @Column
    private Float salario;

    @Column
    private LocalDateTime fecha_ingreso;

//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_Usuarios_Secretaria"))
    Usuarios usuario;
}
