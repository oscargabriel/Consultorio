package com.example.Consultorio.entities.personas;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * personal administrativo
 */
@Entity
public class Administrativos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String funcion;

    @Column
    private LocalDateTime fecha_ingreso;

//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
            foreignKey = @ForeignKey(name = "fk_Usuarios_Administrativos"))
    Usuarios usuario;

}
