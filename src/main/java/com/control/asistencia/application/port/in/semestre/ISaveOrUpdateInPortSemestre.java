package com.control.asistencia.application.port.in.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortSemestre {
    ResponseEntity<?> saveOrUpdateSemestre(SaveCommandGeneric saveCommandGeneric);
}
