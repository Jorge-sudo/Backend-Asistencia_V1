package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.IViewInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerMateriaCarreraSemestre {
    private final IViewInPortMateriaCarreraSemestre iViewInPortMateriaCarreraSemestre;
    public ViewControllerMateriaCarreraSemestre(IViewInPortMateriaCarreraSemestre iViewInPortMateriaCarreraSemestre){
        this.iViewInPortMateriaCarreraSemestre = iViewInPortMateriaCarreraSemestre;
    }
    @GetMapping(path = "/materiaCarreraSemestres/page/{page}/{size}/{shortOrder}/{sortField}")
    ResponseEntity<?> viewPageMateriaCarreraSemestre(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField,
            @RequestParam(value = "globalFilter", required = false) String globalFilter) {

        if (globalFilter == null || globalFilter.isEmpty()) {
            globalFilter = null;
        }

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortField,
                shortOrder,
                globalFilter);

        return  this.iViewInPortMateriaCarreraSemestre.viewPageMateriaCarreraSemestreDTO(command);
    }
    @GetMapping(path = "/materiaCarreraSemestres")
    ResponseEntity<?> viewAllMateriaCarreraSemestre() {
        return  this.iViewInPortMateriaCarreraSemestre.viewAllMateriaCarreraSemestreDTO();
    }
    @GetMapping(path = "/materiaCarreraSemestres/{id}")
    ResponseEntity<?> viewByIdMateriaCarreraSemestre(@PathVariable("id") int id) {
        return this.iViewInPortMateriaCarreraSemestre.viewByIdMateriaCarreraSemestreDTO(id);
    }


}
