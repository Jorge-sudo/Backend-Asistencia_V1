package com.control.asistencia.adapter.in.web.asistencia;

import com.control.asistencia.application.port.in.asistencia.IViewInPortAsistencia;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerAsistencia {
    private final IViewInPortAsistencia iViewInPortAsistencia;
    public ViewControllerAsistencia(IViewInPortAsistencia iViewInPortAsistencia){
        this.iViewInPortAsistencia = iViewInPortAsistencia;
    }
    @GetMapping(path = "/asistencias/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageAsistencia(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy ){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return this.iViewInPortAsistencia.viewPageAsistencia(command);
    }
}
