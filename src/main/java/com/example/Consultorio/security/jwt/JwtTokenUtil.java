package com.example.Consultorio.security.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * generacion y validacion de los token JWT
 */
@Component
public class JwtTokenUtil {

    private static final Logger loggger = LoggerFactory.getLogger(JwtTokenUtil.class);

    //firma personalizada para el token
    @Value("zaos")
    private String jwtSecret;

    //tiempo de expiracion del token
    @Value("86400000")
    private int jwtExpirationMS;

    //crear el token para la comunicacion
    public String generateJwtToken(Authentication authentication){

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())//asigna el usuario
                .setIssuedAt(new Date())//fecha de creacion
                .setExpiration(new Date(new Date().getTime()+jwtExpirationMS))//fecha de expiracion
                .signWith(SignatureAlgorithm.HS512,jwtSecret)//firma del token
                .compact();
    }

    //obtener el usuario apartir del token
    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    //TODO: VER ALTERNATIVA A JWTS.PARSER()

    //verificar que el jwt este correcto
    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        }catch (SignatureException e){
            loggger.error("Error JWT firma invalida: {} ", e.getMessage());
        }catch (MalformedJwtException e){
            loggger.error("Error Token invalido: {} ",e.getMessage());
        }catch (ExpiredJwtException e){
            loggger.error("Error Token a expirado: {} ",e.getMessage());
        }catch (UnsupportedJwtException e){
            loggger.error("Error JWT token no es soportado: {} ", e.getMessage());
        }catch (IllegalArgumentException e){
            loggger.error("Error JWT cadena esta vacia: {} ", e.getMessage());
        }

        return false;
    }


}
