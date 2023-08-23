package com.control.asistencia.application.port.in.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortSemestre {
    ResponseEntity<?> saveOrUpdateSemestre(SaveOrViewCommandGeneric saveOrViewCommandGeneric);
}
