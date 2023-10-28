package com.control.asistencia.adapter.in.web.asistencia;

import com.control.asistencia.application.port.in.asistencia.IViewInPortAsistencia;
import com.control.asistencia.application.port.in.asistencia.command.CommandPageAsistencia;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
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

    @GetMapping(path = "/asistencias/page/date/{page}/{size}/{shortOrder}/{sortField}/{idCarrera}/{idSemestre}/{fechaSearch}")
    ResponseEntity<?> viewPageFindAllByFechaAsistencia(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField,
            @PathVariable("idCarrera") int idCarrera,
            @PathVariable("idSemestre") int idSemestre,
            @PathVariable("fechaSearch") String fechaSearch,
            @RequestParam(value = "globalFilter", required = false) String globalFilter){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortField,
                shortOrder);

        CommandPageAsistencia commandAsistencia = new CommandPageAsistencia(
                idCarrera,
                idSemestre,
                globalFilter,
                fechaSearch
        );

        return this.iViewInPortAsistencia.viewPageByFechaAndGlobalFilterAsistencia(command, commandAsistencia);
    }
}
