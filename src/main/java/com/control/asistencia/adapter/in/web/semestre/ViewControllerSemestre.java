package com.control.asistencia.adapter.in.web.semestre;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.semestre.IViewServiceSemestre;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerSemestre {
    private final IViewServiceSemestre iViewServiceSemestre;
    public ViewControllerSemestre(IViewServiceSemestre iViewServiceSemestre){
        this.iViewServiceSemestre = iViewServiceSemestre;
    }
    @GetMapping(path = "/semestres")
    ResponseEntity<?> viewAllSemestres(){
        ResponseEntity<?> response;
        try{
            response = ResponseBuilderApiRest.view(
                  this.iViewServiceSemestre.viewAllSemestreDTO()
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
}
