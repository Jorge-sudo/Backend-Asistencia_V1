package com.control.asistencia.application.service.turno;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.turno.IViewInPortTurno;
import com.control.asistencia.application.port.out.turno.IViewOutPortTurno;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplTurno implements IViewInPortTurno {
    private final IViewOutPortTurno iViewOutPortTurno;
    public ViewInPortImplTurno(IViewOutPortTurno iViewOutPortTurno) {
        this.iViewOutPortTurno = iViewOutPortTurno;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewAllTurno() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortTurno.viewAllTurno()
        );
    }
}
