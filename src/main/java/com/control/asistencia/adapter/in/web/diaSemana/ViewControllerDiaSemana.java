package com.control.asistencia.adapter.in.web.diaSemana;

import com.control.asistencia.application.port.in.diaSemana.IViewInPortDiaSemana;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerDiaSemana {
    private final IViewInPortDiaSemana  iViewInPortDiaSemana;
    public ViewControllerDiaSemana(IViewInPortDiaSemana iViewInPortDiaSemana) {
        this.iViewInPortDiaSemana = iViewInPortDiaSemana;
    }
    @GetMapping(path = "/diasSemana")
    ResponseEntity<?> viewAllDiaSemana(){
        return this.iViewInPortDiaSemana.viewAllDiaSemanaDTO();
    }

}
