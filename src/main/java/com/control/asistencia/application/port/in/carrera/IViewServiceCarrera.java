package com.control.asistencia.application.port.in.carrera;

import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;
import java.util.Set;

public interface IViewServiceCarrera {
    Optional<Set<GenericDTO>> viewAllCarreraDTO();
}
