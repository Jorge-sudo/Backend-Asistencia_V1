package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;

import java.util.Optional;

public interface ISaveOutPortMateriaCarreraSemestre {
    Optional<ViewMateriaCarreraSemestreDTO> saveSaveMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre);
}
