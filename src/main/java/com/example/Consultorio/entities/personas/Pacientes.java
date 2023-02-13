package com.example.Consultorio.entities.personas;
import jakarta.persistence.*;

/**
 * pacientes se añaden una vez que se realiza una consulta y pueden estar activos
 */
@Entity
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean activo;




//============================================ASOCIACIONES============================================
    @OneToOne
    @JoinColumn(name = "usuario_id",
        foreignKey = @ForeignKey(name = "fk_Usuarios_Doctores"))
    Usuarios usuario;

}
