package com.control.asistencia.adapter.in.web.horario;

import com.control.asistencia.application.port.in.horario.IViewInPortHorario;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerHorario {
    private final IViewInPortHorario iViewInPortHorario;
    public ViewControllerHorario(IViewInPortHorario iViewInPortHorario) {
        this.iViewInPortHorario = iViewInPortHorario;
    }

    @GetMapping(path = "/horarios")
    ResponseEntity<?> viewAllHorario(){
        return this.iViewInPortHorario.viewAllHorarioDTO();
    }
}
