package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.domain.materia.MateriaDTO;

import java.util.Optional;

public interface ISaveOrUpdateOutPortMateria {
    Optional<MateriaDTO> saveOrUpdateMateria(MateriaDTO materiaDTO);
}
