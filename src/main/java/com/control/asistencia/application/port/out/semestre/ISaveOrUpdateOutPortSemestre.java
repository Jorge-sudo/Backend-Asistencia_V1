package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;

public interface ISaveOrUpdateOutPortSemestre {
    Optional<GenericDTO> saveOrUpdateSemestre(GenericDTO genericDTO);
}
