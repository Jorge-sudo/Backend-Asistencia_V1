package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;
import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortCarrera {
    Optional<Set<GenericDTO>> viewAllCarreraDTO();

}
