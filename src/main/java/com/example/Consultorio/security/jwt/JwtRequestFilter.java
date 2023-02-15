package com.example.Consultorio.security.jwt;

import com.example.Consultorio.security.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * se ejecuta por cada peticion entrante con el fin de validar el token JWT
 * en caso de que lo sea se añade el contexto para indicar que un usuario esta autenticado
 */
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    public static final String BEARER = "Bearer";

    //@Autowired
    private JwtTokenUtil jwtTokenUtil;

    //@Autowired
    private UserDetailsServiceImpl userDetailsService;


    /**
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt!=null && jwtTokenUtil.validateJwtToken(jwt)){
                String username = jwtTokenUtil.getUserNameFromJwtToken(jwt);
                //extrae el usuario
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }catch (Exception e){
            logger.error("Error no se pudo realizar la autenticacion: {} ",e);
        }
        filterChain.doFilter(request,response);
    }

    /**
     * apartir de una cabecera autorizada extrae el token
     * @param request
     * @return
     */
    private String parseJwt(HttpServletRequest request){
        String headerAuth = request.getHeader("AUthorization");

        if(StringUtils.hasText(headerAuth) && headerAuth.startsWith(BEARER)){
            return headerAuth.substring(BEARER.length());
        }
        return null;
    }



}
