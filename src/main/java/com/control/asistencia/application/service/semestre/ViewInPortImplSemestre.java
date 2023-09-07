package com.control.asistencia.application.service.semestre;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.semestre.IViewInPortSemestre;
import com.control.asistencia.application.port.out.semestre.IViewOutPortSemestre;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplSemestre implements IViewInPortSemestre {
    private final IViewOutPortSemestre iViewOutPortSemestre;
    public ViewInPortImplSemestre(IViewOutPortSemestre iViewOutPortSemestre) {
        this.iViewOutPortSemestre = iViewOutPortSemestre;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewAllSemestreDTO() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortSemestre.viewAllSemestreDTO()
        );
    }
}
