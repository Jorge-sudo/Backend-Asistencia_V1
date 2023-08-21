package com.control.asistencia.adapter.in.web.carrera;

import com.control.asistencia.application.port.in.carrera.IDeleteInPortCarrera;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class DeleteControllerCarrera {
    private final IDeleteInPortCarrera iDeleteInPortCarrera;
    public DeleteControllerCarrera(IDeleteInPortCarrera iDeleteInPortCarrera){
        this.iDeleteInPortCarrera = iDeleteInPortCarrera;
    }
    // se define el endpoint y el método HTTP que acepta (en este caso POST)
    @DeleteMapping("/carreras/{id}")
    ResponseEntity<?> deleteCarrera( @PathVariable int id){
        return this.iDeleteInPortCarrera.deleteCarrera(id);
    }
}
