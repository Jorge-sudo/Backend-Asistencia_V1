package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.UpdateActivoCommandMateriaCarreraSemestre;

public interface IUpdateOutPortMateriaCarreraSemestre {
    boolean updateMateriaCarreraSemestreActivo(
            UpdateActivoCommandMateriaCarreraSemestre command);
}
