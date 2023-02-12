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

    @Column
    private int cedula;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private LocalDateTime fecha_nacimiento;

    @Column
    private String direcion;

    @Column
    private String email;

    @Column
    private String usuario;

    @Column
    private String clave;

//============================================ASOCIACIONES============================================
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
        joinColumns = {
                @JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "fk_usuariorol_usuarios"))
        },
        inverseJoinColumns = {
                @JoinColumn(name = "roles_id",foreignKey = @ForeignKey(name = "fk_usuariorol_roles")) })
    private Set<Roles> roles;
}
