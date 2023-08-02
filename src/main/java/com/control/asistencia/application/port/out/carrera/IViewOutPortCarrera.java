package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortCarrera {
    Optional<Set<SaveCommandGeneric>> viewAllCarreraDTO();

}
