package com.control.asistencia.config.exception.exceptions;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TokenNotFoundEcxeptionMessage extends JwtException {
    public TokenNotFoundEcxeptionMessage(String message) {
        super(message);
    }
}
