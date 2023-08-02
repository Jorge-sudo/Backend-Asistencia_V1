package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;

public interface ISaveOrUpdateOutPortCarrera {
    Optional<SaveCommandGeneric> saveOrUpdateCarrera(SaveCommandGeneric saveCommandGeneric);
}
