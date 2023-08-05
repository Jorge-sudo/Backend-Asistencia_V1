package com.control.asistencia.adapter.in.web.materia;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.materia.IViewInPortMateria;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerMateria {
    private final IViewInPortMateria iViewInPortMateria;
    public ViewControllerMateria(IViewInPortMateria iViewInPortMateria){
        this.iViewInPortMateria = iViewInPortMateria;
    }

    @GetMapping(path = "/materias/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageMateria(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy ){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return ResponseBuilderApiRest.viewPage(
                this.iViewInPortMateria.viewPageMateriaDTO(command)
        );
    }

    @GetMapping(path = "/materias/{sigla}")
    ResponseEntity<?> viewByIdMateria(@PathVariable String sigla){
        return ResponseBuilderApiRest.view(
                this.iViewInPortMateria.viewByIdMateriaDTO(sigla)
        );
    }
}
