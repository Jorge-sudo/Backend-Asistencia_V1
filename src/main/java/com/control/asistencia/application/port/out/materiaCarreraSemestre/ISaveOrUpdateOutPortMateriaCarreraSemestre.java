package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.domain.materiaCarreraSemestre.MateriaCarreraSemestreViewDTO;

import java.util.Optional;

public interface ISaveOrUpdateOutPortMateriaCarreraSemestre {
    Optional<MateriaCarreraSemestreViewDTO> saveOrUpdateMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre);
}
