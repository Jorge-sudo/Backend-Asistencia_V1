package com.control.asistencia.adapter.in.web.horario;

import com.control.asistencia.application.port.in.horario.ISaveOrUpdateInPortHorario;
import com.control.asistencia.application.port.in.horario.command.SaveCommandHorario;
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
public class SaveOrUpdateControllerHorario {
    private final ISaveOrUpdateInPortHorario iSaveOrUpdateInPortHorario;
    public SaveOrUpdateControllerHorario(ISaveOrUpdateInPortHorario iSaveOrUpdateInPortHorario) {
        this.iSaveOrUpdateInPortHorario = iSaveOrUpdateInPortHorario;
    }
    @PostMapping("/horarios")
    ResponseEntity<?> saveOrUpdateHorario(@RequestBody @Valid SaveCommandHorario data) {
        return this.iSaveOrUpdateInPortHorario.saveOrUpdateHorario(data);
    }
}
