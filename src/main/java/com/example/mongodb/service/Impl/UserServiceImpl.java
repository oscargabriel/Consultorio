package com.example.mongodb.service.Impl;


import com.example.mongodb.dto.AuthToken;
import com.example.mongodb.dto.LoginUser;
import com.example.mongodb.entities.User;
import com.example.mongodb.exception.customizations.custom.UserToDeleteNotFound;
import com.example.mongodb.repository.UserRepository;
import com.example.mongodb.repository.dao.Impl.RepositoryCriteriaImpl;
import com.example.mongodb.repository.dao.RepositoryPersonalized;
import com.example.mongodb.security.jwt.JwtAuthenticationFilter;
import com.example.mongodb.security.jwt.TokenProvider;
import com.example.mongodb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    RepositoryPersonalized repositoryPersonalized;

    UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder bcryptEncoder;

    private final TokenProvider jwtTokenUtil;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    public UserServiceImpl(RepositoryCriteriaImpl repositoryPersonalized,
                           UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           TokenProvider jwtTokenUtil,
                           BCryptPasswordEncoder bcryptEncoder,
                            JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.repositoryPersonalized = repositoryPersonalized;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.bcryptEncoder = bcryptEncoder;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
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
    public User update(User user) {
        return user;
    }

    @Override
    public String delete(Long id) {
        //se obtiene el username del que esta haciendo la peticion
        List<String> roles = repositoryPersonalized.findRolesByUsername(jwtAuthenticationFilter.getUsername());
        //se obtiene el usuario para verificar que exista y generar un reporte
        User user = repositoryPersonalized.findUserById(id);
        //se verifica que exista, si no existe se envia una exepcion
        if(user ==null){
            throw new UserToDeleteNotFound(HttpStatus.EXPECTATION_FAILED,"administrador "+jwtAuthenticationFilter.getUsername()+" intento eliminar un usuario invalido");
        }
        //se quita la password para el reporte
        user.setPassword(" ");

        roles.forEach(x -> {
            if (x.equalsIgnoreCase("ADMIN")){
                //genera un reporte indicando quien realizo la accion y a quien se borro
                logger.info("administrador "
                        +jwtAuthenticationFilter.getUsername()+
                        " elimino a "
                        +user);
                userRepository.deleteById(String.valueOf(id));
            }
        });
        //se retorna el nombre del usuario eliminado
        return "usuario "+user.getUsername()+" eliminado con exito";
    }
}
