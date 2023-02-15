package com.example.Consultorio.security.config;


import com.example.Consultorio.security.jwt.JwtAuthEntryPoint;
import com.example.Consultorio.security.jwt.JwtRequestFilter;
import com.example.Consultorio.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

/**
 * configuracion de seguridad
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Bean
    public JwtRequestFilter authenticationJwtTokenFilter(){
        return new JwtRequestFilter();
    }




    /**
     * Configuracion global de CORS para toda la aplicacion
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();

        //dominios desde donde se puede hacer solicitud
        configuration.setAllowedOriginPatterns(List.of("http://localhost:4200"));
        //metodos http permitidos
        configuration.setAllowedMethods(List.of("GET","POST","DELETE","PUT","PATCH","OPTIONS"));
        //lista de encavezados permitidos
        configuration.setAllowedHeaders(List.of("Access-Control-Allow-Origin", "X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        //permitir el envio de credenciales
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }



}
