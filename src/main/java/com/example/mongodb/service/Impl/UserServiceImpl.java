package com.example.mongodb.service.Impl;


import com.example.mongodb.dto.AuthToken;
import com.example.mongodb.dto.LoginUser;
import com.example.mongodb.entities.User;
import com.example.mongodb.repository.UserRepository;
import com.example.mongodb.repository.dao.Impl.RepositoryCriteriaImpl;
import com.example.mongodb.repository.dao.RepositoryPersonalized;
import com.example.mongodb.security.jwt.TokenProvider;
import com.example.mongodb.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    RepositoryPersonalized repositoryPersonalized;

    UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder bcryptEncoder;

    private final TokenProvider jwtTokenUtil;


    public UserServiceImpl(RepositoryCriteriaImpl repositoryPersonalized,
                           UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           TokenProvider jwtTokenUtil,
                           BCryptPasswordEncoder bcryptEncoder) {
        this.repositoryPersonalized = repositoryPersonalized;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public User saveUser(User user) {
        System.out.println("service");
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return repositoryPersonalized.findAllUser();
    }

    @Override
    public AuthToken authenticate(LoginUser loginUser) {
        System.out.println("service "+loginUser.getUsername());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        System.out.println("service2 "+loginUser.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("service3 "+loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(authentication);
        System.err.println("termino");
        return new AuthToken(token);
    }

    @Override
    public User update(User userdto) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
