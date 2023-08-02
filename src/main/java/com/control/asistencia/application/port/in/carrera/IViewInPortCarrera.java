package com.control.asistencia.application.port.in.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewInPortCarrera {
    Optional<Set<SaveCommandGeneric>> viewAllCarreraDTO();
}
