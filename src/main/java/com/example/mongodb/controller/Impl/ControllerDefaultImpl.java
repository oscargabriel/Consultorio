package com.example.mongodb.controller.Impl;


import com.example.mongodb.controller.ControllerDefault;
import com.example.mongodb.dto.LoginUser;
import com.example.mongodb.entities.User;
import com.example.mongodb.exception.customizations.custom.InvalidExpressionException;
import com.example.mongodb.service.Impl.UserServiceImpl;
import com.example.mongodb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//http://localhost:8080/tutorials
@RestController
public class ControllerDefaultImpl implements ControllerDefault {
    Logger logger = LoggerFactory.getLogger(ControllerDefaultImpl.class);
    private String regex = null;
    private Pattern pat = null;
    private Matcher math = null;


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
        logger.info("registrando usuario "+user.getUsername());
        //validaciones que las expreciones regulares sean correctas
        validarExprecionRegular(user.getEmail(), "email");
        validarExprecionRegular(user.getUsername(), "username");
        validarExprecionRegular(user.getPassword(), "password");
        validarExprecionRegular(user.getPhone(), "phone");
        validarExprecionRegular(user.getName(), "name");
        validarExprecionRegular(user.getLastName(), "lastname");
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
        logger.info("autenticando a l usuario "+loginUser.getUsername());
        validarExprecionRegular(loginUser.getPassword(), "password");
        validarExprecionRegular(loginUser.getUsername(), "username");
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

    /**
     * funcion para validar las expreciones regulares que se reciven desde autenticacion o registro
     * si la cadena es aceptada continuara, de ser negativa se crea una expepcion InvalidExpressionExcepction
     * y se envia al usuario el tipo que fallo
     * @param cadena la cadena que va verificar (name, phone, email, password, username...)
     * @param tipo el tipo de cadena que corresponde
     */
    protected void validarExprecionRegular(String cadena, String tipo){
        switch (tipo) {
            case "email":
                regex = "^([A-Za-z0-9]{1})([-_\\.A-Za-z0-9]{0,})([A-Za-z0-9]{1})@([A-Za-z0-9\\.]+)*([A-Za-z]{2,})$";
                break;
            case "username":
                regex = "^([A-Za-z0-9]{1})([A-Za-z0-9-_\\.]{2,20})([A-Za-z0-9]{1})$";
                break;
            case "password":
                regex = "^([A-Za-z0-9-_@#%\\.\\+\\$\\*]{4,30})$";
                break;
            case "phone":
                regex = "^([\\+]{0,1})([0-9]{3,})$";
                break;
            case "name":
            case "lastname":
                regex = "^([A-Za-z]{4,30})$";
                break;
            case "fecha":
                regex = "^([0-9]{1,2})/([0-9]{1,2})/([0-9]{2,4})$";
                break;

            default:
                regex=null;
        }
        if(regex!=null) {
            Pattern pat = Pattern.compile(regex);
            math = pat.matcher(cadena);
            if(!math.find()){
                throw new InvalidExpressionException(HttpStatus.PRECONDITION_FAILED,"el campo de " +tipo+" no es valido");
            }
        }

    }
}
