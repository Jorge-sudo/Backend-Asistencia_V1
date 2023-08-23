package com.control.asistencia.adapter.in.web.turno;

import com.control.asistencia.application.port.in.turno.IViewInPortTurno;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerTurno {
    private final IViewInPortTurno iViewInPortTurno;
    public ViewControllerTurno(IViewInPortTurno iViewInPortTurno) {
        this.iViewInPortTurno = iViewInPortTurno;
    }
    @GetMapping(path = "/turnos")
    ResponseEntity<?> viewAllTurno(){
        return this.iViewInPortTurno.viewAllTurno();
    }
}
