package com.control.asistencia.application.port.in.aula;

import org.springframework.http.ResponseEntity;

public interface IDeleteInPortAula {
    ResponseEntity<?> deleteAula(int idAula);
}
