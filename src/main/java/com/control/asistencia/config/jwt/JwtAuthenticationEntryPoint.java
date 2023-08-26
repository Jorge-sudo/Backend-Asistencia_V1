package com.control.asistencia.config.jwt;


import com.control.asistencia.config.security.ConstantesSeguridad;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

//Clase para poder manejar las excepciones de tipo autenticación en nuestra app
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    private JwtGenerador jwtGenerador;
    public JwtAuthenticationEntryPoint(JwtGenerador jwtGenerador) {
        this.jwtGenerador = jwtGenerador;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        String token = request.getHeader(ConstantesSeguridad.HEADER_AUTHORIZATION_KEY);

        if (token == null || token.isEmpty()) {
            logger.warn("No se proporcionó un token de autenticación");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No se proporcionó un token de autenticación");
            return;
        }

        boolean tokenValido = jwtGenerador.validarToken(token);

        if (!tokenValido) {
            logger.warn("El token de autenticación es inválido o ha expirado");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "El token de autenticación es inválido o ha expirado");
            return;
        }

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
