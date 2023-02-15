package com.example.Consultorio.security.service;

import com.example.Consultorio.dto.UsuariosDAOImpl;
import com.example.Consultorio.entities.personas.Usuarios;
import com.example.Consultorio.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuariosDAOImpl dao = new UsuariosDAOImpl();
        Usuarios usuario = dao.findByUsername(username);
        if(usuario!=null){
            // TODO: EXEPCION SI NO EXISTE EL USUARIO
        }
        return new org.springframework.security.core.userdetails.User(
                usuario.getUsuario(),
                usuario.getClave(),
                new ArrayList<>()
        );
    }
}
