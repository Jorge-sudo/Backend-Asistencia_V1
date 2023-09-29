package com.control.asistencia.application.port.in.docente;

import com.control.asistencia.application.port.in.docente.command.UpdateActivoCommandDocente;
import org.springframework.http.ResponseEntity;

public interface IUpdateInPortDocente {
    ResponseEntity<?> updateDocenteActivo(UpdateActivoCommandDocente command);
}
