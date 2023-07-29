package com.control.asistencia.adapter.in.web.utilController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExceptionHandlerUtil {
    private static final Logger logger = LogManager.getLogger(ExceptionHandlerUtil.class);
    public static ResponseEntity<?> handleException(Exception e) {
        ResponseEntity<?> response;

        if (e instanceof DataAccessException) {
            response = ResponseBuilderApiRest.errorWithData(
                    Optional.empty(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            response = ResponseBuilderApiRest.error(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Imprimir el error en el registro
        logger.error(e.toString());

        return response;
    }
}
