package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.ISaveServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveControllerMateriaCarreraSemestre {
    private final ISaveServiceMateriaCarreraSemestre iSaveServiceMateriaCarreraSemestre;
    public SaveControllerMateriaCarreraSemestre(ISaveServiceMateriaCarreraSemestre iSaveServiceMateriaCarreraSemestre){
        this.iSaveServiceMateriaCarreraSemestre = iSaveServiceMateriaCarreraSemestre;
    }

    @PostMapping("/materiaCarreraSemestres") // se define el endpoint y el método HTTP que acepta (en este caso POST)
    ResponseEntity<?> saveMateriaCarreraSemestre(
            @RequestBody SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre) {

        Map<String, Object> response = new HashMap<>(); // se crea un nuevo mapa para almacenar la respuesta de la solicitud
        response.put("mensaje", "La MateriaCarreraSemestres ha sido guardada con éxito"); // se agrega un mensaje de éxito a la respuesta
        response.put("result", this.iSaveServiceMateriaCarreraSemestre.saveMateriaCarreraSemestre(saveCommandMateriaCarreraSemestre));
        return new ResponseEntity<>(response, HttpStatus.CREATED); // se devuelve una respuesta HTTP 201 (creado) junto con la respuesta
    }
}
