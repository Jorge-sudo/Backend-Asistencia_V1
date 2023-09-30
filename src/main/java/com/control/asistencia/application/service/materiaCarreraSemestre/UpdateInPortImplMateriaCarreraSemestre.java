package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.IUpdateInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.UpdateActivoCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IUpdateOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.http.ResponseEntity;

@UseCase
public class UpdateInPortImplMateriaCarreraSemestre implements
            IUpdateInPortMateriaCarreraSemestre {
    private final IUpdateOutPortMateriaCarreraSemestre iUpdateOutPortMateriaCarreraSemestre;
    public UpdateInPortImplMateriaCarreraSemestre(IUpdateOutPortMateriaCarreraSemestre iUpdateOutPortMateriaCarreraSemestre) {
        this.iUpdateOutPortMateriaCarreraSemestre = iUpdateOutPortMateriaCarreraSemestre;
    }

    @Override
    public ResponseEntity<?> updateMateriaCarreraSemestreActivo(UpdateActivoCommandMateriaCarreraSemestre command) {
        return ResponseBuilderApiRest.updateActivo(
                iUpdateOutPortMateriaCarreraSemestre.updateMateriaCarreraSemestreActivo(command));
    }
}
