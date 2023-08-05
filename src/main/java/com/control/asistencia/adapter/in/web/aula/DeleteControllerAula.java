package com.control.asistencia.adapter.in.web.aula;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.aula.IDeleteInPortAula;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class DeleteControllerAula {
    private final IDeleteInPortAula iDeleteInPortAula;
    public DeleteControllerAula(IDeleteInPortAula iDeleteInPortAula){
        this.iDeleteInPortAula = iDeleteInPortAula;
    }
    @DeleteMapping ("/aulas/{id}")
    ResponseEntity<?> deleteAula(
            @PathVariable  int id){

        return ResponseBuilderApiRest.delete(
                this.iDeleteInPortAula.deleteAula(id)
        );
    }
}
