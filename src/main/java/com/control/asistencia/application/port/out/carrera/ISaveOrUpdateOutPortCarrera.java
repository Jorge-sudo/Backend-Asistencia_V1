package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.Optional;

public interface ISaveOrUpdateOutPortCarrera {
    Optional<SaveOrViewCommandGeneric> saveOrUpdateCarrera(SaveOrViewCommandGeneric saveOrViewCommandGeneric);
}
