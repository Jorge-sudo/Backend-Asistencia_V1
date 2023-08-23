package com.control.asistencia.application.service.diaSemana;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.diaSemana.IViewInPortDiaSemana;
import com.control.asistencia.application.port.out.diaSemana.IViewOutPortDiaSemana;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;

@UseCase
public class ViewInPortImplDiaSemana implements IViewInPortDiaSemana {
    private final IViewOutPortDiaSemana iViewOutPortDiaSemana;
    public ViewInPortImplDiaSemana(IViewOutPortDiaSemana iViewOutPortDiaSemana) {
        this.iViewOutPortDiaSemana = iViewOutPortDiaSemana;
    }
    @Override
    public ResponseEntity<?> viewAllDiaSemanaDTO() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortDiaSemana.viewAllDiaSemanaDTO()
        );
    }
}
