package com.control.asistencia.adapter.in.web.rol;

import com.control.asistencia.application.port.in.rol.IViewInPortRol;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerRol {
    private final IViewInPortRol iViewInPortRol;
    public ViewControllerRol(IViewInPortRol iViewInPortRol) {
        this.iViewInPortRol = iViewInPortRol;
    }

    @GetMapping(path = "/roles")
    ResponseEntity<?> viewAllRol(){
        return this.iViewInPortRol.viewAllRol();
    }
}
