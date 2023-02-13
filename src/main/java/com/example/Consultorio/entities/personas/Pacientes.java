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
    private Usuarios usuario;

    public Pacientes() {
    }

    public Pacientes(Long id, Boolean activo) {
        this.id = id;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
