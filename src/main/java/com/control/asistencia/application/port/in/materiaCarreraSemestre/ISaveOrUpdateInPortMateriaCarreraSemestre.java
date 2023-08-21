package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import org.springframework.http.ResponseEntity;


public interface ISaveOrUpdateInPortMateriaCarreraSemestre {
    ResponseEntity<?> saveOrUpdateMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre);
}
