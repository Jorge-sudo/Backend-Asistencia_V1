package com.control.asistencia.application.service.carrera;

import com.control.asistencia.application.port.in.carrera.IDeleteServiceCarrera;
import com.control.asistencia.application.port.out.carrera.IDeleteOutPortCarrera;
import com.control.asistencia.common.UseCase;

@UseCase
public class DeleteServiceImplCarrera implements IDeleteServiceCarrera {
    private final IDeleteOutPortCarrera iDeleteOutPortCarrera;
    public  DeleteServiceImplCarrera(IDeleteOutPortCarrera iDeleteOutPortCarrera){
        this.iDeleteOutPortCarrera = iDeleteOutPortCarrera;
    }

    @Override
    public boolean deleteCarrera(int id) {
        return this.iDeleteOutPortCarrera.deleteCarrera(id);
    }
}
