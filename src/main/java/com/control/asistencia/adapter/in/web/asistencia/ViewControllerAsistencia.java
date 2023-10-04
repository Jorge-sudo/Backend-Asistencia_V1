package com.control.asistencia.adapter.in.web.asistencia;

import com.control.asistencia.application.port.in.asistencia.IViewInPortAsistencia;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerAsistencia {
    private final IViewInPortAsistencia iViewInPortAsistencia;
    public ViewControllerAsistencia(IViewInPortAsistencia iViewInPortAsistencia){
        this.iViewInPortAsistencia = iViewInPortAsistencia;
    }
    @GetMapping(path = "/asistencias/page/search/{page}/{size}/{shortOrder}/{sortField}")
    ResponseEntity<?> viewPageGlobalFilterAsistencia(
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


        return this.iViewInPortAsistencia.viewPageGlobalFilterAsistencia(command);
    }

    @GetMapping(path = "/asistencias/page/date/{page}/{size}/{shortOrder}/{sortField}/{fechaSearch}")
    ResponseEntity<?> viewPageFindAllByFechaAsistencia(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField,
            @PathVariable("fechaSearch") String fechaSearch){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortField,
                shortOrder);

        return this.iViewInPortAsistencia.viewPageFindAllByFechaAsistencia(command, fechaSearch);
    }
}
