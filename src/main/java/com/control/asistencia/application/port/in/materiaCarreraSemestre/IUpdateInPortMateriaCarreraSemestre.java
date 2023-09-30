package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.UpdateActivoCommandMateriaCarreraSemestre;
import org.springframework.http.ResponseEntity;

public interface IUpdateInPortMateriaCarreraSemestre {
    ResponseEntity<?> updateMateriaCarreraSemestreActivo(
            UpdateActivoCommandMateriaCarreraSemestre command);
}
