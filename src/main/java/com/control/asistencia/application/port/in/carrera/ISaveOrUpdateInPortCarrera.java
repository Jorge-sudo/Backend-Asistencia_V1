package com.control.asistencia.application.port.in.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;

public interface ISaveOrUpdateInPortCarrera {
    Optional<SaveCommandGeneric> saveOrUpdateCarrera(SaveCommandGeneric saveCommandGeneric);
}
