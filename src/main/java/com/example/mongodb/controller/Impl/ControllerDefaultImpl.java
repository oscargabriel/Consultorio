package com.example.mongodb.controller.Impl;


import com.example.mongodb.controller.ControllerDefault;
import com.example.mongodb.dto.LoginUser;
import com.example.mongodb.entities.User;
import com.example.mongodb.service.Impl.UserServiceImpl;
import com.example.mongodb.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//http://localhost:8080/tutorials
@RestController
public class ControllerDefaultImpl implements ControllerDefault {

    UserService userService;

    public ControllerDefaultImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/hola")
    public ResponseEntity<String> hola() {
        return ResponseEntity.ok("hola base");
    }

    @Override
    @GetMapping("/hola_authenticate")
    public ResponseEntity<String> holaauthenticate() {
        return ResponseEntity.ok("hola authenticate");
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello_user")
    public ResponseEntity<String> userPing() {
        return ResponseEntity.ok("hola USER");
    }

    @Override
    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/hello_employee")
    public ResponseEntity<String> employeePing() {
        return ResponseEntity.ok("hola EMPLOYEE");
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello_admin")
    public ResponseEntity<String> adminPing() {
        return ResponseEntity.ok("hola ADMIN");
    }

    @Override
    public ResponseEntity<String> useremployeeePing() {
        return null;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("register");
        System.out.println(user.toString());
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @Override
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());

    }

    @Override
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody LoginUser loginUser) {
        System.out.println("controller");
        return ResponseEntity.ok(userService.authenticate(loginUser));
    }

    @Override
    public ResponseEntity<User> update(User user) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }
}
