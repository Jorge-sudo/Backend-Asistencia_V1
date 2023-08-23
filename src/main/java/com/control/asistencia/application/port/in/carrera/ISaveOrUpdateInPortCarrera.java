package com.control.asistencia.application.port.in.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import org.springframework.http.ResponseEntity;


public interface ISaveOrUpdateInPortCarrera {
    ResponseEntity<?> saveOrUpdateCarrera(SaveOrViewCommandGeneric saveOrViewCommandGeneric);
}
