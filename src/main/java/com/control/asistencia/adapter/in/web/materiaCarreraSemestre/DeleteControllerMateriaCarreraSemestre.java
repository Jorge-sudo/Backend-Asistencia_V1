package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.IDeleteInPortMateriaCarreraSemestre;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequestMapping("/api")
public class DeleteControllerMateriaCarreraSemestre {
    private final IDeleteInPortMateriaCarreraSemestre iDeleteInPortMateriaCarreraSemestre;
    public DeleteControllerMateriaCarreraSemestre(IDeleteInPortMateriaCarreraSemestre iDeleteInPortMateriaCarreraSemestre){
        this.iDeleteInPortMateriaCarreraSemestre = iDeleteInPortMateriaCarreraSemestre;
    }

    // se define el endpoint y el método HTTP que acepta (en este caso POST)
    @DeleteMapping("/materiaCarreraSemestres/{id}")
    ResponseEntity<?> deleteMateriaCarreraSemestre(@PathVariable int id){
        return ResponseBuilderApiRest.delete(
                this.iDeleteInPortMateriaCarreraSemestre.deleteMateriaCarrera(id)
        );
    }
}
