package com.control.asistencia.application.port.in.asistencia;

import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortAsistencia {
    ResponseEntity<?> saveOrUpdateAsistencia(CommandAsistencia command);
}
