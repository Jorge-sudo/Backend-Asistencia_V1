package com.control.asistencia.application.port.in.docente;

import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortDocente {
    ResponseEntity<?> saveOrUpdateDocente(SaveCommandDocente saveCommandDocente);
}
