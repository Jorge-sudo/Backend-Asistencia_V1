package com.control.asistencia.application.port.in.materia;

import org.springframework.http.ResponseEntity;

public interface IDeleteInPortMateria {
    ResponseEntity<?> deleteMateria(String sigla);
}
