package com.example.Consultorio.entities.personas;

import com.example.Consultorio.entities.Consultas;
import com.example.Consultorio.entities.Roles;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id",
            foreignKey = @ForeignKey(name = "fk_usuariorol_usuario"))
    private Usuarios usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id",
            foreignKey = @ForeignKey(name = "fk_usuariorol_rol"))
    private Roles rol;

    public UsuarioRol() {
    }

    public UsuarioRol(Long id, Usuarios usuario, Roles rol) {
        this.id = id;
        this.usuario = usuario;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
