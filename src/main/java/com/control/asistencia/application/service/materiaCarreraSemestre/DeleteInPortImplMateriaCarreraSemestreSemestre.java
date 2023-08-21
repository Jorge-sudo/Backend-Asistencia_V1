package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.IDeleteInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IDeleteOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class DeleteInPortImplMateriaCarreraSemestreSemestre implements IDeleteInPortMateriaCarreraSemestre {
    private final IDeleteOutPortMateriaCarreraSemestre iDeleteOutPortMateriaCarreraSemestre;
    public DeleteInPortImplMateriaCarreraSemestreSemestre(IDeleteOutPortMateriaCarreraSemestre iDeleteOutPortMateriaCarreraSemestre) {
        this.iDeleteOutPortMateriaCarreraSemestre = iDeleteOutPortMateriaCarreraSemestre;
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteMateriaCarrera(int id) {
        return ResponseBuilderApiRest.delete(
                this.iDeleteOutPortMateriaCarreraSemestre.deleteMateriaCarreraSemestre(id)
        );
    }
}
