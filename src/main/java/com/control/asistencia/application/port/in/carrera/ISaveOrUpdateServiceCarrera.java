package com.control.asistencia.application.port.in.carrera;

import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;

public interface ISaveOrUpdateServiceCarrera {
    Optional<GenericDTO> saveOrUpdateCarrera(GenericDTO genericDTO);
}
