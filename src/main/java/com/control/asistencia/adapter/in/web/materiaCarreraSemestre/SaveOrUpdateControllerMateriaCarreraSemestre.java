package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ISaveOrUpdateServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerMateriaCarreraSemestre {
    private final ISaveOrUpdateServiceMateriaCarreraSemestre iSaveOrUpdateServiceMateriaCarreraSemestre;
    public SaveOrUpdateControllerMateriaCarreraSemestre(ISaveOrUpdateServiceMateriaCarreraSemestre iSaveOrUpdateServiceMateriaCarreraSemestre){
        this.iSaveOrUpdateServiceMateriaCarreraSemestre = iSaveOrUpdateServiceMateriaCarreraSemestre;
    }
    @PostMapping("/materiaCarreraSemestres")
    ResponseEntity<?> saveOrUpdateMateriaCarreraSemestre(
            @RequestBody SaveCommandMateriaCarreraSemestre command) {
        ResponseEntity<?> response;
        try {
            response = command.getIdMateriaCarreraSemestre() > 0
                    ? ResponseBuilderApiRest.update(
                            this.iSaveOrUpdateServiceMateriaCarreraSemestre.saveOrUpdateMateriaCarreraSemestre(command)
                    )
                    : ResponseBuilderApiRest.save(
                            this.iSaveOrUpdateServiceMateriaCarreraSemestre.saveOrUpdateMateriaCarreraSemestre(command)
                    );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
}
