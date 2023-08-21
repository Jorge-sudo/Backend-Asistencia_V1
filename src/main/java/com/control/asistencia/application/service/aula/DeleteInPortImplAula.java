package com.control.asistencia.application.service.aula;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.aula.IDeleteInPortAula;
import com.control.asistencia.application.port.out.aula.IDeleteOutPortAula;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class DeleteInPortImplAula implements
        IDeleteInPortAula {
    private final IDeleteOutPortAula iDeleteOutPortAula;
    public DeleteInPortImplAula(IDeleteOutPortAula iDeleteOutPortAula){
        this.iDeleteOutPortAula = iDeleteOutPortAula;
    }
    @Override
    @Transactional
    public ResponseEntity<?> deleteAula(int idAula) {
        return ResponseBuilderApiRest.delete(
                this.iDeleteOutPortAula.deleteAula(idAula)
        );
    }
}
