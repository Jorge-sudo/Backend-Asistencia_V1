package com.control.asistencia.adapter.in.web.semestre;

import com.control.asistencia.application.port.in.semestre.IDeleteInPortSemestre;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequestMapping("/api")
public class DeleteControllerSemestre {
    private final IDeleteInPortSemestre iDeleteInPortSemestre;
    public DeleteControllerSemestre(IDeleteInPortSemestre iDeleteInPortSemestre){
        this.iDeleteInPortSemestre = iDeleteInPortSemestre;
    }
    // se define el endpoint y el método HTTP que acepta (en este caso POST)
    @DeleteMapping("/semestres/{id}")
    ResponseEntity<?> deleteSemestre(@PathVariable int id){
        return this.iDeleteInPortSemestre.deleteSemestre(id);
    }
}
