package com.control.asistencia.config.exception.exceptions;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TokenExpiredException extends JwtException {
    public TokenExpiredException(String message) {
        super(message);
    }
    // Puedes agregar constructores adicionales si es necesario
}
