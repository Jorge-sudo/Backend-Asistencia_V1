package com.control.asistencia.application.port.in.carrera;

import org.springframework.http.ResponseEntity;

public interface IDeleteInPortCarrera {
    ResponseEntity<?> deleteCarrera(int id);
}
