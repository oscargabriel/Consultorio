package com.example.Consultorio.controller;

import com.example.Consultorio.dto.AuthToken;
import com.example.Consultorio.dto.LoginUser;
import com.example.Consultorio.dto.UserDto;
import com.example.Consultorio.entities.User;
import com.example.Consultorio.security.Jwt.TokenProvider;
import com.example.Consultorio.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;
    private UserService userService;


    public UserController(TokenProvider jwtTokenUtil, UserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;

    }

    @GetMapping("/findall")
    public List<User> findAll(){
        List<User> user = userService.findAll();

        return user;
    }

    @GetMapping("/hola")
    public String hola(){
        log.info("ejecutando saludo");
        return "hola";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }


    @PostMapping("/register")
    public User saveUser(@RequestBody UserDto user){
        // TODO lanzar excepción customizada
        // throw new EmailAlreadyExistsException("Email ocupado");
        return userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/hello-admin-user")
    public String adminUser(){
        return "Only Admins and Users Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello-user")
    public String userPing(){
        return "Any User Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id){
        return userService.findById(null);
    }



}
