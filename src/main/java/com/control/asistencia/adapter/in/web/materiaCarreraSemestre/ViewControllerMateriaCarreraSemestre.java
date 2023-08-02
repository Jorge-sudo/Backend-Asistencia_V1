package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.IViewInPortMateriaCarreraSemestre;
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
public class ViewControllerMateriaCarreraSemestre {
    private final IViewInPortMateriaCarreraSemestre iViewInPortMateriaCarreraSemestre;
    public ViewControllerMateriaCarreraSemestre(IViewInPortMateriaCarreraSemestre iViewInPortMateriaCarreraSemestre){
        this.iViewInPortMateriaCarreraSemestre = iViewInPortMateriaCarreraSemestre;
    }
    @GetMapping(path = "/materiaCarreraSemestres/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageMateriaCarreraSemestre(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy) {

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return ResponseBuilderApiRest.view(
                this.iViewInPortMateriaCarreraSemestre.viewPageMateriaCarreraSemestreDTO(command)
        );
    }
    @GetMapping(path = "/materiaCarreraSemestres")
    ResponseEntity<?> viewAllMateriaCarreraSemestre() {
        return ResponseBuilderApiRest.view(
                this.iViewInPortMateriaCarreraSemestre.viewAllMateriaCarreraSemestreDTO()
        );
    }
    @GetMapping(path = "/materiaCarreraSemestres/{id}")
    ResponseEntity<?> viewByIdMateriaCarreraSemestre(@PathVariable("id") int id) {
        return ResponseBuilderApiRest.view(
                this.iViewInPortMateriaCarreraSemestre.viewByIdMateriaCarreraSemestreDTO(id)
        );
    }


}
