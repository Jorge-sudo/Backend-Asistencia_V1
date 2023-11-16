package com.control.asistencia.config.jwt;

import com.control.asistencia.config.security.UserDetailsImpl;
import io.jsonwebtoken.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import java.util.Date;

@Component
public class JwtGenerador {

    public String generarToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Date tiempoActual = new Date();
        Date HourExpirationToken = new
                Date(tiempoActual.getTime() + JwtSecurityConstants.JWT_EXPIRATION_TOKEN);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(HourExpirationToken)
                .signWith(JwtSecurityConstants.JWT_FIRMA, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, JwtSecurityConstants.JWT_COOKIE_NAME);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(Authentication authentication) {
        String jwt = generarToken(authentication);
        return ResponseCookie.from(JwtSecurityConstants.JWT_COOKIE_NAME, jwt)
                .path("/api")
                .maxAge( 60 * 60)
                .httpOnly(true)
                .sameSite("None")
                .secure(true)
                .build();
    }

    public ResponseCookie getCleanJwtCookie() {
        return ResponseCookie.from(JwtSecurityConstants.JWT_COOKIE_NAME, null)
                .path("/api").build();
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
        try{
            Jwts.parserBuilder()
                    .setSigningKey(JwtSecurityConstants.JWT_FIRMA)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

}