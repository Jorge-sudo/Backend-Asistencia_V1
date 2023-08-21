package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.ISaveOrUpdateInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
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
public class SaveOrUpdateControllerMateriaCarreraSemestre {
    private final ISaveOrUpdateInPortMateriaCarreraSemestre iSaveOrUpdateInPortMateriaCarreraSemestre;
    public SaveOrUpdateControllerMateriaCarreraSemestre(ISaveOrUpdateInPortMateriaCarreraSemestre iSaveOrUpdateInPortMateriaCarreraSemestre){
        this.iSaveOrUpdateInPortMateriaCarreraSemestre = iSaveOrUpdateInPortMateriaCarreraSemestre;
    }
    @PostMapping("/materiaCarreraSemestres")
    ResponseEntity<?> saveOrUpdateMateriaCarreraSemestre(
            @RequestBody @Valid SaveCommandMateriaCarreraSemestre command) {
        return this.iSaveOrUpdateInPortMateriaCarreraSemestre.saveOrUpdateMateriaCarreraSemestre(command);
    }
}
