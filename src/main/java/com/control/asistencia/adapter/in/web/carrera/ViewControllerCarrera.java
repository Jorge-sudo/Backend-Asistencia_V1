package com.control.asistencia.adapter.in.web.carrera;

import com.control.asistencia.application.port.in.carrera.IViewInPortCarrera;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerCarrera {
    private final IViewInPortCarrera iViewInPortCarrera;
    public ViewControllerCarrera(IViewInPortCarrera iViewInPortCarrera){
        this.iViewInPortCarrera = iViewInPortCarrera;
    }

    @GetMapping(path = "/carreras")
    ResponseEntity<?> viewAllCarreras(){
        return this.iViewInPortCarrera.viewAllCarreraDTO();
    }
}
