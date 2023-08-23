package com.control.asistencia.application.port.in.diaSemana;

import org.springframework.http.ResponseEntity;

public interface IViewInPortDiaSemana {
    ResponseEntity<?> viewAllDiaSemanaDTO();
}
