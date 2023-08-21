package com.control.asistencia.adapter.in.web.docente;

import com.control.asistencia.application.port.in.docente.ISaveOrUpdateInPortDocente;
import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
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
public class SaveOrUpdateControllerDocente {
    private final ISaveOrUpdateInPortDocente iSaveOrUpdateInPortDocente;
    public SaveOrUpdateControllerDocente(
            ISaveOrUpdateInPortDocente iSaveOrUpdateInPortDocente ){

        this.iSaveOrUpdateInPortDocente = iSaveOrUpdateInPortDocente;
    }
    @PostMapping("/docentes")
    ResponseEntity<?> saveOrUpdateDocente(@RequestBody @Valid SaveCommandDocente data){
        return this.iSaveOrUpdateInPortDocente.saveOrUpdateDocente(data);
    }
}
