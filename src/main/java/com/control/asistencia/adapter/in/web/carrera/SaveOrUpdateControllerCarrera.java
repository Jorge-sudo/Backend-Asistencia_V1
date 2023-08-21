package com.control.asistencia.adapter.in.web.carrera;

import com.control.asistencia.application.port.in.carrera.ISaveOrUpdateInPortCarrera;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import com.control.asistencia.common.WebAdapter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerCarrera {
    private final ISaveOrUpdateInPortCarrera iSaveOrUpdateInPortCarrera;
    public SaveOrUpdateControllerCarrera(ISaveOrUpdateInPortCarrera iSaveOrUpdateInPortCarrera){
        this.iSaveOrUpdateInPortCarrera = iSaveOrUpdateInPortCarrera;
    }
    ResponseEntity<?> saveOrUpdateCarrera(@RequestBody @Valid SaveCommandGeneric data){
        return this.iSaveOrUpdateInPortCarrera.saveOrUpdateCarrera(data);
    }
}
