package com.example.Consultorio.controller;


import com.example.Consultorio.security.config.TokenProvider;
import com.example.Consultorio.security.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {


    private AuthenticationManager authenticationManager;

    private TokenProvider jwtTokenUtil;

    private UsuariosService usuariosService;


}
