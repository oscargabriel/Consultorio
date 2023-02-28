package com.example.mongodb.service.Impl;

import com.example.mongodb.entities.User;
import com.example.mongodb.repository.dao.RepositoryPersonalized;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserDetailServiceImpl implements UserDetailsService {



    RepositoryPersonalized repositoryPersonalized;



    public UserDetailServiceImpl(RepositoryPersonalized repositoryPersonalized) {
        this.repositoryPersonalized = repositoryPersonalized;

    }

    /**
     * implementada desde UserDetailService para verificar que el usuario y la clave sean validas
     * @param username String dado
     * @return user de la clase security.core
     * @throws UsernameNotFoundException expecion
     */
    @Override
    public UserDetails loadUserByUsername(String username){
        System.out.println("loadUserByUsername");
        //verifica que el username exista si no devuelve una expecion
        User user = repositoryPersonalized.findUserByUsername(username);
        if(user == null){
            throw new BadCredentialsException("Usuario invalido "+username);
        }
        System.out.println("loadUserByUsername "+user.toString());
        //devueelve el usuario y las autorizaciones que tiene el usuario
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),user.getPassword(),getAuthority(user));
    }



    /**
     * se encarga de buscar las authorizaciones que tenga el usuario para la funcion previa
     * @param user usuario de entitie
     * @return authorizaciones que posee el user
     */
    private Set<SimpleGrantedAuthority> getAuthority(User user){
        System.out.println("asignando roles");
        //crea una variable para almacenar las authorizaciones
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        //crea una lista de las authorizaciones
        List<String> roles = repositoryPersonalized.findRolesByUsername(user.getUsername());
        //los asigna y retorna

        roles.forEach( rol -> {
            System.out.println(rol);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+rol));
        });
        return authorities;
    }



}
