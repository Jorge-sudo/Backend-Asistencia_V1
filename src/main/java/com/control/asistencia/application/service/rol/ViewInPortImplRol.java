package com.control.asistencia.application.service.rol;

import com.control.asistencia.application.port.in.rol.IViewInPortRol;
import com.control.asistencia.application.port.out.rol.IViewOutPortRol;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.http.ResponseEntity;

@UseCase
public class ViewInPortImplRol implements IViewInPortRol {
    private final IViewOutPortRol iViewOutPortRol;
    public ViewInPortImplRol(IViewOutPortRol iViewOutPortRol) {
        this.iViewOutPortRol = iViewOutPortRol;
    }
    @Override
    public ResponseEntity<?> viewAllRol() {
        return ResponseBuilderApiRest.view(this.iViewOutPortRol.viewAllRol());
    }
}
