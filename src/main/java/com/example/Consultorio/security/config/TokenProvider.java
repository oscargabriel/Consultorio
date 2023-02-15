package com.example.Consultorio.security.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TokenProvider implements Serializable {

    @Value("18000")
    public long TOKEN_VALIDITY;

    @Value("signingkey")
    public String SIGNING_KEY;

    @Value("roles")
    public String AUTHORITIES_KEY;

    public String getUsernameFromToken(String token){
        return "";
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * verificar si el token a expirado
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * funcion para generar el token con el tiempo de vida
     * @param authentication
     * @return retorna los valores del token
     */
    public String generateToken(Authentication authentication){
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder().setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY,authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.ES256,SIGNING_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String userName = getUsernameFromToken(token);
        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    UsernamePasswordAuthenticationToken getAuthenticationToken(final String token,
                                                               final Authentication existingAuth,
                                                               final UserDetails userDetails){

        final JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);// todo revisar

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());//todo revisar

        return new UsernamePasswordAuthenticationToken(userDetails,"",authorities);
    }

}
