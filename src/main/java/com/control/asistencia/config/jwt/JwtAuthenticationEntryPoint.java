package com.control.asistencia.config.jwt;


import com.control.asistencia.config.exception.exceptions.TokenExpiredExceptionMessage;
import com.control.asistencia.config.exception.exceptions.TokenNotFoundExceptionMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

//Clase para poder manejar las excepciones de tipo autenticación en nuestra app
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final JwtGenerador jwtGenerador;
    public JwtAuthenticationEntryPoint(JwtGenerador jwtGenerador) {
        this.jwtGenerador = jwtGenerador;
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException {

        String token =  this.jwtGenerador.getJwtFromCookies(request);

        if (token == null || token.isEmpty()) {
            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "No se proporcionó un token de autenticación");
            throw new TokenNotFoundExceptionMessage("No se proporcionó un token de autenticación");
        }

        boolean tokenValido = jwtGenerador.validarToken(token);

        if (!tokenValido) {
            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "El token de autenticación es inválido o ha expirado");
            throw new TokenExpiredExceptionMessage("El token de autenticación es inválido o ha expirado");
        }

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
