package com.control.asistencia.application.service.materia;

import com.control.asistencia.application.port.in.materia.IDeleteServiceMateria;
import com.control.asistencia.application.port.out.materia.IDeleteOutPortMateria;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteServiceImplMateria implements IDeleteServiceMateria {
    private final IDeleteOutPortMateria iDeleteOutPortMateria;
    public  DeleteServiceImplMateria(IDeleteOutPortMateria iDeleteOutPortMateria){
        this.iDeleteOutPortMateria = iDeleteOutPortMateria;
    }

    @Override
    public boolean deleteMateria(String sigla) {
        return this.iDeleteOutPortMateria.deleteMateria(sigla);
    }
}
