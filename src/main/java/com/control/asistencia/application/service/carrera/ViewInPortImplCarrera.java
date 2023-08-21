package com.control.asistencia.application.service.carrera;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.carrera.IViewInPortCarrera;
import com.control.asistencia.application.port.out.carrera.IViewOutPortCarrera;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


@UseCase
public class ViewInPortImplCarrera implements IViewInPortCarrera {
    private final IViewOutPortCarrera iViewOutPortCarrera;
    public ViewInPortImplCarrera(IViewOutPortCarrera iViewOutPortCarrera) {
        this.iViewOutPortCarrera = iViewOutPortCarrera;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewAllCarreraDTO() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortCarrera.viewAllCarreraDTO()
        );
    }
}
