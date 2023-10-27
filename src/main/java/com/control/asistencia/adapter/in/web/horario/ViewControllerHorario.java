package com.control.asistencia.adapter.in.web.horario;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.application.port.in.horario.IViewInPortHorario;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(path = "/horarios/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageHorario(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy ){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return this.iViewInPortHorario.viewPageHorarioDTO(command);
    }

    @GetMapping(path = "/horarios")
    ResponseEntity<?> viewAllHorario(){
        return this.iViewInPortHorario.viewAllHorarioDTO();
    }
}
