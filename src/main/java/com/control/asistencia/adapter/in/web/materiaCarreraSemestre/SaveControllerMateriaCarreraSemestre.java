package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ISaveServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.common.WebAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveControllerMateriaCarreraSemestre {
    private final ISaveServiceMateriaCarreraSemestre iSaveServiceMateriaCarreraSemestre;
    private final Logger logger = LogManager.getLogger(SaveControllerMateriaCarreraSemestre.class);
    public SaveControllerMateriaCarreraSemestre(ISaveServiceMateriaCarreraSemestre iSaveServiceMateriaCarreraSemestre){
        this.iSaveServiceMateriaCarreraSemestre = iSaveServiceMateriaCarreraSemestre;
    }
    @PostMapping("/materiaCarreraSemestres") // se define el endpoint y el método HTTP que acepta (en este caso POST)
    ResponseEntity<?> saveMateriaCarreraSemestre(
            @RequestBody SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre) {
        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.save(
                    this.iSaveServiceMateriaCarreraSemestre.saveMateriaCarreraSemestre(saveCommandMateriaCarreraSemestre)
            );
        } catch (DataAccessException e) {
            response = ResponseBuilderApiRest.errorWithData(
                    Optional.empty(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ResponseBuilderApiRest.error(
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        }
        return response;
    }
}
