package com.control.asistencia.config.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundExceptionMessage extends RuntimeException {
    public DataNotFoundExceptionMessage(String message) {
        super(message);
    }
    public DataNotFoundExceptionMessage(String message, Throwable cause) {
        super(message, cause);
    }
}
