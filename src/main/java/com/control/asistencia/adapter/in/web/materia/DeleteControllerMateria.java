package com.control.asistencia.adapter.in.web.materia;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materia.IDeleteServiceMateria;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class DeleteControllerMateria {
    private final IDeleteServiceMateria iDeleteServiceMateria;
    public DeleteControllerMateria(IDeleteServiceMateria iDeleteServiceMateria){
        this.iDeleteServiceMateria = iDeleteServiceMateria;
    }
    // se define el endpoint y el método HTTP que acepta (en este caso POST)
    @DeleteMapping("/materias/{sigla}")
    ResponseEntity<?> deleteMateria(
            @PathVariable String sigla){
        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.delete(
                    this.iDeleteServiceMateria.deleteMateria(sigla)
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
}
