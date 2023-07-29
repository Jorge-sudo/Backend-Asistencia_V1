package com.control.asistencia.application.port.in.semestre;

import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;
import java.util.Set;

public interface IViewServiceSemestre {
    Optional<Set<GenericDTO>> viewAllSemestreDTO();
}
