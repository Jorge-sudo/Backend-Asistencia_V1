package com.control.asistencia.adapter.in.web.carrera;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.carrera.ISaveOrUpdateServiceCarrera;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.domain.generic.GenericDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerCarrera {
    private final ISaveOrUpdateServiceCarrera iSaveOrUpdateServiceCarrera;
    public SaveOrUpdateControllerCarrera(ISaveOrUpdateServiceCarrera iSaveOrUpdateServiceCarrera){
        this.iSaveOrUpdateServiceCarrera = iSaveOrUpdateServiceCarrera;
    }
    @PostMapping("/carreras")
    ResponseEntity<?> saveOrUpdateCarrera(@RequestBody GenericDTO data){
        ResponseEntity<?> response;
        try {
            response = data.getId() > 0
                    ? ResponseBuilderApiRest.update(
                            this.iSaveOrUpdateServiceCarrera.saveOrUpdateCarrera(data)
                )
                    : ResponseBuilderApiRest.save(
                            this.iSaveOrUpdateServiceCarrera.saveOrUpdateCarrera(data)
                );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
}
