package com.example.Consultorio.entities.personas;
import com.example.Consultorio.entities.Roles;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * puede ver los datos de su ultima consulta
 */
@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private int cedula;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;
    @Column(length = 100, nullable = false)
    private String direccion;

    @Column(length = 100, nullable = true)
    private String telefono;

    @Column(length = 40, unique = true, nullable = false)
    private String email;

    @Column(length = 40, unique = true, nullable = false)
    private String usuario;

    @Column(length = 40, nullable = false)
    private String clave;

//============================================ASOCIACIONES============================================
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USUARIO_ROL",
        joinColumns = {
                @JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "fk_usuariorol_usuarios"))
        },
        inverseJoinColumns = {
                @JoinColumn(name = "rol_id",foreignKey = @ForeignKey(name = "fk_usuariorol_roles")) })
    private Set<Roles> roles;
}
