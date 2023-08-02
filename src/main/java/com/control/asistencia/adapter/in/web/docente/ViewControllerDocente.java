package com.control.asistencia.adapter.in.web.docente;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.docente.IViewInPortDocente;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerDocente {
    private final IViewInPortDocente iViewInPortDocente;
    public ViewControllerDocente(IViewInPortDocente iViewInPortDocente){
        this.iViewInPortDocente = iViewInPortDocente;
    }
    @GetMapping("/docentes/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageDocente(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy ){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return ResponseBuilderApiRest.view(
                this.iViewInPortDocente.viewPageDocenteDTO(command)
        );

    }

    @GetMapping("/docentes/{ci}")
    ResponseEntity<?> viewByCiDocente(
            @PathVariable("ci") long ci){

        return ResponseBuilderApiRest.view(
                this.iViewInPortDocente.viewByCiDocenteDTO(ci)
        );

    }

}
