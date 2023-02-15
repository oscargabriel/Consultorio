package com.example.Consultorio.security.service.impl;

import com.example.Consultorio.repository.UsuariosDAOImpl;
import com.example.Consultorio.security.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UsuariosServiceImpl implements UserDetailsService, com.example.Consultorio.security.service.UsuariosService {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private UsuariosDAOImpl usuariosDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return null;
    }

}
