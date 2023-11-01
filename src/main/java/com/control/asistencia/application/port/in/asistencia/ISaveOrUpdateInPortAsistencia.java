package com.control.asistencia.application.port.in.asistencia;

import com.control.asistencia.application.port.in.asistencia.command.CommandAsistenciaForm;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortAsistencia {
    ResponseEntity<?> saveOrUpdateAsistencia(CommandAsistenciaForm command);
}
