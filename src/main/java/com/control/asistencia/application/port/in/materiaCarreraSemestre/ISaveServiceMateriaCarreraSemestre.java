package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;

import java.util.Optional;

public interface ISaveServiceMateriaCarreraSemestre {
    Optional<ViewMateriaCarreraSemestreDTO> saveMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre);
}
