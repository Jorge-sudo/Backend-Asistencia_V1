package com.control.asistencia.application.port.in.semestre;

import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;

public interface ISaveOrUpdateServiceSemestre {
    Optional<GenericDTO> saveOrUpdateSemestre(GenericDTO genericDTO);
}
