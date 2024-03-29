package com.control.asistencia.application.service.horario;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.horario.IDeleteInPortHorario;
import com.control.asistencia.application.port.out.horario.IDeleteOutPortHorario;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class DeleteInPortImplHorario implements IDeleteInPortHorario {
    private final IDeleteOutPortHorario iDeleteOutPortHorario;
    public DeleteInPortImplHorario(IDeleteOutPortHorario iDeleteOutPortHorario) {
        this.iDeleteOutPortHorario = iDeleteOutPortHorario;
    }
    @Override
    @Transactional
    public ResponseEntity<?> deleteHorario(int idHorario) {
        return ResponseBuilderApiRest.delete(
                this.iDeleteOutPortHorario.deleteHorario(idHorario)
        );
    }
}
