package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.IViewServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
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
    private final IViewServiceMateriaCarreraSemestre iViewServiceMateriaCarreraSemestre;
    public ViewControllerMateriaCarreraSemestre(IViewServiceMateriaCarreraSemestre iViewServiceMateriaCarreraSemestre){
        this.iViewServiceMateriaCarreraSemestre = iViewServiceMateriaCarreraSemestre;
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

        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.view(
                    this.iViewServiceMateriaCarreraSemestre.viewPageMateriaCarreraSemestreDTO(command)
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
    @GetMapping(path = "/materiaCarreraSemestres")
    ResponseEntity<?> viewAllMateriaCarreraSemestre() {
        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.view(
                    this.iViewServiceMateriaCarreraSemestre.viewAllMateriaCarreraSemestreDTO()
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
    @GetMapping(path = "/materiaCarreraSemestres/{id}")
    ResponseEntity<?> viewByIdMateriaCarreraSemestre(@PathVariable("id") int id) {
        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.view(
                    this.iViewServiceMateriaCarreraSemestre.viewByIdMateriaCarreraSemestreDTO(id)
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }


}
