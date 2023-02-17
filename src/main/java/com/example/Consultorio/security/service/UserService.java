package com.example.Consultorio.security.service;


import com.example.Consultorio.dto.UserDto;
import com.example.Consultorio.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
    User findById(Long id);
}
