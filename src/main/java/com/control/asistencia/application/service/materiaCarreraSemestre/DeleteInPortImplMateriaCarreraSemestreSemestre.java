package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.IDeleteInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IDeleteOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteInPortImplMateriaCarreraSemestreSemestre implements IDeleteInPortMateriaCarreraSemestre {
    private final IDeleteOutPortMateriaCarreraSemestre iDeleteOutPortMateriaCarreraSemestre;
    public DeleteInPortImplMateriaCarreraSemestreSemestre(IDeleteOutPortMateriaCarreraSemestre iDeleteOutPortMateriaCarreraSemestre) {
        this.iDeleteOutPortMateriaCarreraSemestre = iDeleteOutPortMateriaCarreraSemestre;
    }

    @Override
    public boolean deleteMateriaCarrera(int id) {
        return this.iDeleteOutPortMateriaCarreraSemestre.deleteMateriaCarreraSemestre(id);
    }
}
