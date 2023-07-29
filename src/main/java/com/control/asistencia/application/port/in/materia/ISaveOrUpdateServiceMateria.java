package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.domain.materia.MateriaDTO;

import java.util.Optional;

public interface ISaveOrUpdateServiceMateria {
    Optional<MateriaDTO> saveOrUpdateMateria(MateriaDTO materiaDTO);
}
