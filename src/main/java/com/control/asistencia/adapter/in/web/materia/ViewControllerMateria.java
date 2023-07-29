package com.control.asistencia.adapter.in.web.materia;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.application.port.in.materia.IViewServiceMateria;
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
    private final IViewServiceMateria iViewServiceMateria;
    public ViewControllerMateria(IViewServiceMateria iViewServiceMateria){
        this.iViewServiceMateria = iViewServiceMateria;
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
        ResponseEntity<?> response;
        try{
            response = ResponseBuilderApiRest.view(
                    this.iViewServiceMateria.viewPageMateriaDTO(command)
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }

    @GetMapping(path = "/materias/{sigla}")
    ResponseEntity<?> viewByIdMateria(@PathVariable String sigla){
        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.view(
                this.iViewServiceMateria.viewByIdMateriaDTO(sigla)
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
}
