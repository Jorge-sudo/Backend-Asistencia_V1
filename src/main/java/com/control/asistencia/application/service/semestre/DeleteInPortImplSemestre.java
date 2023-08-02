package com.control.asistencia.application.service.semestre;

import com.control.asistencia.application.port.in.semestre.IDeleteInPortSemestre;
import com.control.asistencia.application.port.out.semestre.IDeleteOutPortSemestre;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteInPortImplSemestre implements IDeleteInPortSemestre {
    private final IDeleteOutPortSemestre iDeleteOutPortSemestre;
    public DeleteInPortImplSemestre(IDeleteOutPortSemestre iDeleteOutPortSemestre){
        this.iDeleteOutPortSemestre = iDeleteOutPortSemestre;
    }

    @Override
    public boolean deleteSemestre(int id) {
        return this.iDeleteOutPortSemestre.deleteSemestre(id);
    }
}
