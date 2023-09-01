package com.control.asistencia.config.exception.exceptions;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TokenNotFoundExceptionMessage extends JwtException {
    public TokenNotFoundExceptionMessage(String message) {
        super(message);
    }
}
