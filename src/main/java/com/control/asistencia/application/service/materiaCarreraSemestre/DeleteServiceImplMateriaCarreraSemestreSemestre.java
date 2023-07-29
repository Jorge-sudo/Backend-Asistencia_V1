package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.IDeleteServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IDeleteOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteServiceImplMateriaCarreraSemestreSemestre implements IDeleteServiceMateriaCarreraSemestre {
    private final IDeleteOutPortMateriaCarreraSemestre iDeleteOutPortMateriaCarreraSemestre;
    public DeleteServiceImplMateriaCarreraSemestreSemestre(IDeleteOutPortMateriaCarreraSemestre iDeleteOutPortMateriaCarreraSemestre) {
        this.iDeleteOutPortMateriaCarreraSemestre = iDeleteOutPortMateriaCarreraSemestre;
    }

    @Override
    public boolean deleteMateriaCarrera(int id) {
        return this.iDeleteOutPortMateriaCarreraSemestre.deleteMateriaCarreraSemestre(id);
    }
}
