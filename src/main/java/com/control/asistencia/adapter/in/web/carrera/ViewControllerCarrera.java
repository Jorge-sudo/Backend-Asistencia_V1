package com.control.asistencia.adapter.in.web.carrera;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.carrera.IViewServiceCarrera;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerCarrera {
    private final IViewServiceCarrera iViewServiceCarrera;
    public ViewControllerCarrera(IViewServiceCarrera iViewServiceCarrera){
        this.iViewServiceCarrera = iViewServiceCarrera;
    }

    @GetMapping(path = "/carreras")
    ResponseEntity<?> viewAllCarreras(){
        ResponseEntity<?> response;
        try{
            response = ResponseBuilderApiRest.view(
                this.iViewServiceCarrera.viewAllCarreraDTO()
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
}
