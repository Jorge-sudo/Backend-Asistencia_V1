package com.control.asistencia.adapter.in.web.docente;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.docente.IViewInPortDocente;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerDocente {
    private final IViewInPortDocente iViewInPortDocente;
    public ViewControllerDocente(IViewInPortDocente iViewInPortDocente){
        this.iViewInPortDocente = iViewInPortDocente;
    }
    @GetMapping("/docentes/page/{page}/{size}/{shortOrder}/{sortField}")
    ResponseEntity<?> viewPageDocente(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField,
            @RequestParam(value = "globalFilter", required = false) String globalFilter){

        if (globalFilter == null || globalFilter.isEmpty()) {
            globalFilter = null;
        }

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortField,
                shortOrder,
                globalFilter);

        return this.iViewInPortDocente.viewPageDocenteDTO(command);

    }

    @GetMapping("/docentes/{ci}")
    ResponseEntity<?> viewByCiDocente(
            @PathVariable("ci") long ci){

        return this.iViewInPortDocente.viewByCiDocenteDTO(ci);

    }

}
