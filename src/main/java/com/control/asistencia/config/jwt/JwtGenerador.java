package com.control.asistencia.config.jwt;

import com.control.asistencia.config.security.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.Date;

@Component
public class JwtGenerador {

    public String generarToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String username = userDetails.getUsername();
        long userId = userDetails.getId();
        Date tiempoActual = new Date();
        Date expiracionToken = new
                Date(tiempoActual.getTime() + JwtSecurityConstants.JWT_EXPIRATION_TOKEN);

        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(expiracionToken)
                .signWith(JwtSecurityConstants.JWT_FIRMA, SignatureAlgorithm.HS512)
                .compact();
    }

    public String obtenerUsernameDeJwt(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(JwtSecurityConstants.JWT_FIRMA)
                .build()
                .parseClaimsJws(token);

        return claims.getBody().getSubject();
    }

    public long obtenerIdDeJwt(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(JwtSecurityConstants.JWT_FIRMA)
                .build()
                .parseClaimsJws(token);

        return claims.getBody().get("userId", Integer.class).longValue();
    }

    public Boolean validarToken(String token) {
        Jwts.parserBuilder()
                .setSigningKey(JwtSecurityConstants.JWT_FIRMA)
                .build()
                .parseClaimsJws(token);

        return true;
    }

}