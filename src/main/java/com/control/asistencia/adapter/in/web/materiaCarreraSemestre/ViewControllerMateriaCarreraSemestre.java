package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.IViewServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.ViewPageCommandMateriaCarreraSemestre;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerMateriaCarreraSemestre {
    private final IViewServiceMateriaCarreraSemestre iViewServiceMateriaCarreraSemestre;
    public ViewControllerMateriaCarreraSemestre(IViewServiceMateriaCarreraSemestre iViewServiceMateriaCarreraSemestre){
        this.iViewServiceMateriaCarreraSemestre = iViewServiceMateriaCarreraSemestre;
    }
    @GetMapping(path = "/materiaCarreraSemestres/page/{page}/{size}/{sortBy}")
    Page<ViewMateriaCarreraSemestreDTO> viewPage(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy) {

        ViewPageCommandMateriaCarreraSemestre command = new ViewPageCommandMateriaCarreraSemestre(
                page,
                size,
                sortBy);

        return this.iViewServiceMateriaCarreraSemestre.viewPageMateriaCarreraSemestreDTO(command);
    }
    @GetMapping(path = "/materiaCarreraSemestres")
    Set<ViewMateriaCarreraSemestreDTO> viewPage() {
        return this.iViewServiceMateriaCarreraSemestre.viewAllMateriaCarreraSemestreDTO();
    }
}
