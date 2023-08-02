package com.control.asistencia.adapter.in.web.semestre;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.semestre.IViewInPortSemestre;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerSemestre {
    private final IViewInPortSemestre iViewInPortSemestre;
    public ViewControllerSemestre(IViewInPortSemestre iViewInPortSemestre){
        this.iViewInPortSemestre = iViewInPortSemestre;
    }
    @GetMapping(path = "/semestres")
    ResponseEntity<?> viewAllSemestres(){
        return ResponseBuilderApiRest.view(
                this.iViewInPortSemestre.viewAllSemestreDTO()
        );
    }
}
