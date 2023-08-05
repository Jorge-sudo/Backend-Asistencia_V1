package com.control.asistencia.application.service.aula;

import com.control.asistencia.application.port.in.aula.IDeleteInPortAula;
import com.control.asistencia.application.port.out.aula.IDeleteOutPortAula;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteInPortImplAula implements
        IDeleteInPortAula {
    private final IDeleteOutPortAula iDeleteOutPortAula;
    public DeleteInPortImplAula(IDeleteOutPortAula iDeleteOutPortAula){
        this.iDeleteOutPortAula = iDeleteOutPortAula;
    }
    @Override
    public boolean deleteAula(int idAula) {
        return this.iDeleteOutPortAula.deleteAula(idAula);
    }
}
