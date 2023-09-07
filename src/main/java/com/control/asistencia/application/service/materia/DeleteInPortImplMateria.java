package com.control.asistencia.application.service.materia;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materia.IDeleteInPortMateria;
import com.control.asistencia.application.port.out.materia.IDeleteOutPortMateria;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class DeleteInPortImplMateria implements IDeleteInPortMateria {
    private final IDeleteOutPortMateria iDeleteOutPortMateria;
    public DeleteInPortImplMateria(IDeleteOutPortMateria iDeleteOutPortMateria){
        this.iDeleteOutPortMateria = iDeleteOutPortMateria;
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteMateria(String sigla) {
        return ResponseBuilderApiRest.delete(
                this.iDeleteOutPortMateria.deleteMateria(sigla)
        );
    }
}
