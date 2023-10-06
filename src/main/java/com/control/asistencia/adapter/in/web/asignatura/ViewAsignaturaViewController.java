package com.control.asistencia.adapter.in.web.asignatura;

import com.control.asistencia.application.port.in.asignatura.command.CommandPageAssignMateria;
import com.control.asistencia.application.port.in.asignatura.IViewInPortAsignaturaView;
import com.control.asistencia.common.WebAdapter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewAsignaturaViewController {
    private final IViewInPortAsignaturaView iViewInPortAsignaturaView;
    public ViewAsignaturaViewController(IViewInPortAsignaturaView iViewInPortAsignaturaView){
        this.iViewInPortAsignaturaView = iViewInPortAsignaturaView;
    }
    @GetMapping(path = "/asignatura/page/{page}/{size}/{shortOrder}/{sortField}/{idCarrera}/{idDia}/{idSemestre}/{idTurno}")
    ResponseEntity<?> viewPageMateriaAssignView(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField,
            @PathVariable("idCarrera") int idCarrera,
            @PathVariable("idDia") int idDia,
            @PathVariable("idSemestre") int idSemestre,
            @PathVariable("idTurno") int idTurno,
            @RequestParam(value = "globalFilter", required = false) String globalFilter){

        if (globalFilter == null || globalFilter.isEmpty()) {
            globalFilter = null;
        }

        @Valid  CommandPageAssignMateria command = new CommandPageAssignMateria(
                page,
                size,
                sortField,
                shortOrder,
                globalFilter,
                idCarrera,
                idSemestre,
                idDia,
                idTurno);

        return this.iViewInPortAsignaturaView.viewPageMateriaAssignView(command);
    }
}
