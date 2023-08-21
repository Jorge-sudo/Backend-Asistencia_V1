package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import org.springframework.http.ResponseEntity;

public interface IDeleteInPortMateriaCarreraSemestre {
    ResponseEntity<?> deleteMateriaCarrera(int id);
}
