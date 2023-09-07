package com.control.asistencia.application.service.semestre;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.semestre.IDeleteInPortSemestre;
import com.control.asistencia.application.port.out.semestre.IDeleteOutPortSemestre;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class DeleteInPortImplSemestre implements IDeleteInPortSemestre {
    private final IDeleteOutPortSemestre iDeleteOutPortSemestre;
    public DeleteInPortImplSemestre(IDeleteOutPortSemestre iDeleteOutPortSemestre){
        this.iDeleteOutPortSemestre = iDeleteOutPortSemestre;
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteSemestre(int id) {
        return ResponseBuilderApiRest.delete(
                this.iDeleteOutPortSemestre.deleteSemestre(id)
        );
    }
}
