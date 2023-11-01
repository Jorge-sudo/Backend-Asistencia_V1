package com.control.asistencia.adapter.in.web.asistencia;

import com.control.asistencia.application.port.in.asistencia.ISaveOrUpdateInPortAsistencia;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistenciaForm;
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
public class SaveOrUpdateControllerAsistencia {
    private final ISaveOrUpdateInPortAsistencia iSaveOrUpdateInPortAsistencia;
    public SaveOrUpdateControllerAsistencia(
            ISaveOrUpdateInPortAsistencia iSaveOrUpdateInPortAsistencia){
        this.iSaveOrUpdateInPortAsistencia = iSaveOrUpdateInPortAsistencia;
    }

    @PostMapping("/asistencias")
    ResponseEntity<?> saveOrUpdateAsistencia(@RequestBody @Valid CommandAsistenciaForm data){
        return this.iSaveOrUpdateInPortAsistencia.saveOrUpdateAsistencia(data);
    }
}
