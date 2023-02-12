package com.example.Consultorio.entities.personas;
import com.example.Consultorio.entities.Roles;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//============================================ASOCIACIONES============================================
    /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
        joinColumns = {
                @JoinColumn(name = "USER_ID")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "ROLE_ID") })
    private Set<Roles> roles;*/
}
