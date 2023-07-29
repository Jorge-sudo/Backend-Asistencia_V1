package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortSemestre {
    Optional<Set<GenericDTO>> viewAllSemestreDTO();
}
