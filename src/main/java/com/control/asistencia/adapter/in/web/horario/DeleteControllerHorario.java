package com.control.asistencia.adapter.in.web.horario;

import com.control.asistencia.application.port.in.horario.IDeleteInPortHorario;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class DeleteControllerHorario {
    private final IDeleteInPortHorario iDeleteInPortHorario;
    public DeleteControllerHorario(IDeleteInPortHorario iDeleteInPortHorario) {
        this.iDeleteInPortHorario = iDeleteInPortHorario;
    }
    @DeleteMapping(path = "/horarios/{id}")
    ResponseEntity<?> deleteHorario(@PathVariable  int id){
        return this.iDeleteInPortHorario.deleteHorario(id);
    }
}
