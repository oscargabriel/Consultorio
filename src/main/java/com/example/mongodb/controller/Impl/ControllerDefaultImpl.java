package com.example.mongodb.controller.Impl;


import com.example.mongodb.controller.ControllerDefault;
import com.example.mongodb.dto.LoginUser;
import com.example.mongodb.entities.User;
import com.example.mongodb.service.Impl.UserServiceImpl;
import com.example.mongodb.service.UserService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> holaauthenticate() {
        return null;
    }

    @Override
    public ResponseEntity<String> userPing() {
        return null;
    }

    @Override
    public ResponseEntity<String> employeePing() {
        return null;
    }

    @Override
    public ResponseEntity<String> adminPing() {
        return null;
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
    public ResponseEntity<?> authenticate(LoginUser loginUser) {
        return null;
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
