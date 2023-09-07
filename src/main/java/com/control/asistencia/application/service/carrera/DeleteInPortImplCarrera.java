package com.control.asistencia.application.service.carrera;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.carrera.IDeleteInPortCarrera;
import com.control.asistencia.application.port.out.carrera.IDeleteOutPortCarrera;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class DeleteInPortImplCarrera implements IDeleteInPortCarrera {
    private final IDeleteOutPortCarrera iDeleteOutPortCarrera;
    public DeleteInPortImplCarrera(IDeleteOutPortCarrera iDeleteOutPortCarrera){
        this.iDeleteOutPortCarrera = iDeleteOutPortCarrera;
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteCarrera(int id) {
        return ResponseBuilderApiRest.delete(
                this.iDeleteOutPortCarrera.deleteCarrera(id)
        );
    }
}
