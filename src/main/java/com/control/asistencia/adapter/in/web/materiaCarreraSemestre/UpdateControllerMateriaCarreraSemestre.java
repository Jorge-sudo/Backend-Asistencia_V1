package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.IUpdateInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.UpdateActivoCommandMateriaCarreraSemestre;
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
public class UpdateControllerMateriaCarreraSemestre {
    private final IUpdateInPortMateriaCarreraSemestre iUpdateInPortMateriaCarreraSemestre;
    public UpdateControllerMateriaCarreraSemestre(
            IUpdateInPortMateriaCarreraSemestre iUpdateInPortMateriaCarreraSemestre) {
        this.iUpdateInPortMateriaCarreraSemestre = iUpdateInPortMateriaCarreraSemestre;
    }

    @PostMapping("/materiaCarreraSemestres/activo")
    ResponseEntity<?> updateMateriaCarreraSemestreActivo(
            @RequestBody @Valid UpdateActivoCommandMateriaCarreraSemestre command){

        return this.iUpdateInPortMateriaCarreraSemestre.updateMateriaCarreraSemestreActivo(
                command);
    }
}
