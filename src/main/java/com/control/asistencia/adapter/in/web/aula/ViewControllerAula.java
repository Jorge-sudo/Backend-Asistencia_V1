package com.control.asistencia.adapter.in.web.aula;

import com.control.asistencia.application.port.in.aula.IViewInPortAula;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerAula {
    private final IViewInPortAula iViewInPortAula;
    public ViewControllerAula(IViewInPortAula iViewInPortAula){
        this.iViewInPortAula = iViewInPortAula;
    }

    @GetMapping(path = "/aulas/{id}")
    ResponseEntity<?> viewByIdAula(
            @PathVariable("id") int id){
        return this.iViewInPortAula.viewByIdAulaDTO(id);
    }

    @GetMapping(path = "/aulas")
    ResponseEntity<?> viewAllAula(){
        return this.iViewInPortAula.viewAllAulaDTO();
    }
}
