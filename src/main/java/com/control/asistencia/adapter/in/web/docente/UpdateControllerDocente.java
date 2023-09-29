package com.control.asistencia.adapter.in.web.docente;

import com.control.asistencia.application.port.in.docente.IUpdateInPortDocente;
import com.control.asistencia.application.port.in.docente.command.UpdateActivoCommandDocente;
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
public class UpdateControllerDocente {
    private final IUpdateInPortDocente iUpdateInPortDocente;
    public UpdateControllerDocente(IUpdateInPortDocente iUpdateInPortDocente) {
        this.iUpdateInPortDocente = iUpdateInPortDocente;
    }

    @PostMapping("/docentes/activo")
    ResponseEntity<?> updateDocenteActivo(
            @RequestBody @Valid UpdateActivoCommandDocente command){
        return this.iUpdateInPortDocente.updateDocenteActivo(command);
    }
}
