package com.control.asistencia.application.port.in.semestre;

import org.springframework.http.ResponseEntity;

public interface IViewInPortSemestre {
    ResponseEntity<?> viewAllSemestreDTO();
}
