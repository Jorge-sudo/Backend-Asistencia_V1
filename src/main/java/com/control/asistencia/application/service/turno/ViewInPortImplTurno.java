package com.control.asistencia.application.service.turno;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.turno.IViewInPortTurno;
import com.control.asistencia.application.port.out.turno.IViewOutPortTurno;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;

@UseCase
public class ViewInPortImplTurno implements IViewInPortTurno {
    private final IViewOutPortTurno iViewOutPortTurno;
    public ViewInPortImplTurno(IViewOutPortTurno iViewOutPortTurno) {
        this.iViewOutPortTurno = iViewOutPortTurno;
    }
    @Override
    public ResponseEntity<?> viewAllTurno() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortTurno.viewAllTurno()
        );
    }
}
