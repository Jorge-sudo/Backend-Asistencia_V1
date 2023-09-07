package com.control.asistencia.application.service.diaSemana;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.diaSemana.IViewInPortDiaSemana;
import com.control.asistencia.application.port.out.diaSemana.IViewOutPortDiaSemana;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplDiaSemana implements IViewInPortDiaSemana {
    private final IViewOutPortDiaSemana iViewOutPortDiaSemana;
    public ViewInPortImplDiaSemana(IViewOutPortDiaSemana iViewOutPortDiaSemana) {
        this.iViewOutPortDiaSemana = iViewOutPortDiaSemana;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewAllDiaSemanaDTO() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortDiaSemana.viewAllDiaSemanaDTO()
        );
    }
}
