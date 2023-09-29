package com.control.asistencia.application.service.docente;

import com.control.asistencia.application.port.in.docente.IUpdateInPortDocente;
import com.control.asistencia.application.port.in.docente.command.UpdateActivoCommandDocente;
import com.control.asistencia.application.port.out.docente.IUpdateOutPortDocente;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class UpdateInPortImplDocente implements IUpdateInPortDocente {
    private final IUpdateOutPortDocente iUpdateOutPortDocente;
    public UpdateInPortImplDocente(IUpdateOutPortDocente iUpdateOutPortDocente) {
        this.iUpdateOutPortDocente = iUpdateOutPortDocente;
    }


    @Override
    @Transactional
    public ResponseEntity<?> updateDocenteActivo(UpdateActivoCommandDocente command) {
        return ResponseBuilderApiRest.updateActivo(
                iUpdateOutPortDocente.updateDocenteActivo(command));
    }
}
