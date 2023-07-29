package com.control.asistencia.application.service.semestre;

import com.control.asistencia.application.port.in.semestre.IDeleteServiceSemestre;
import com.control.asistencia.application.port.out.semestre.IDeleteOutPortSemestre;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteServiceImplSemestre implements IDeleteServiceSemestre {
    private final IDeleteOutPortSemestre iDeleteOutPortSemestre;
    public  DeleteServiceImplSemestre(IDeleteOutPortSemestre iDeleteOutPortSemestre){
        this.iDeleteOutPortSemestre = iDeleteOutPortSemestre;
    }

    @Override
    public boolean deleteSemestre(int id) {
        return this.iDeleteOutPortSemestre.deleteSemestre(id);
    }
}
