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

    public Usuarios() {
    }

    public Usuarios(Long id, int cedula, String nombre, String apellido, LocalDateTime fechaNacimiento, String direccion, String telefono, String email, String usuario, String clave) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
