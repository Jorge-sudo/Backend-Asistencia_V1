package com.control.asistencia.application.service.materia;

import com.control.asistencia.application.port.in.materia.IDeleteInPortMateria;
import com.control.asistencia.application.port.out.materia.IDeleteOutPortMateria;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteInPortImplMateria implements IDeleteInPortMateria {
    private final IDeleteOutPortMateria iDeleteOutPortMateria;
    public DeleteInPortImplMateria(IDeleteOutPortMateria iDeleteOutPortMateria){
        this.iDeleteOutPortMateria = iDeleteOutPortMateria;
    }

    @Override
    public boolean deleteMateria(String sigla) {
        return this.iDeleteOutPortMateria.deleteMateria(sigla);
    }
}
