package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;

public interface ISaveOrUpdateOutPortCarrera {
    Optional<GenericDTO> saveOrUpdateCarrera(GenericDTO genericDTO);
}
