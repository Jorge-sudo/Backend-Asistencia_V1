package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortCarrera {
    Optional<Set<SaveOrViewCommandGeneric>> viewAllCarreraDTO();

}
