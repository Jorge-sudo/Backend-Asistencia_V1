package com.control.asistencia.application.port.in.horario;

import org.springframework.http.ResponseEntity;

public interface IDeleteInPortHorario {
    ResponseEntity<?> deleteHorario(int idHorario);
}
