package com.control.asistencia.adapter.in.web.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import com.control.asistencia.application.port.in.semestre.ISaveOrUpdateInPortSemestre;
import com.control.asistencia.common.WebAdapter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerSemestre {
    private final ISaveOrUpdateInPortSemestre iSaveOrUpdateInPortSemestre;
    public SaveOrUpdateControllerSemestre(ISaveOrUpdateInPortSemestre iSaveOrUpdateInPortSemestre){
        this.iSaveOrUpdateInPortSemestre = iSaveOrUpdateInPortSemestre;
    }
    @PostMapping("/semestres")
    ResponseEntity<?> saveOrUpdateSemestre(@RequestBody @Valid SaveOrViewCommandGeneric data){
        return this.iSaveOrUpdateInPortSemestre.saveOrUpdateSemestre(data);
    }

}
