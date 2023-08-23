package com.control.asistencia.application.service.horario;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.horario.ISaveOrUpdateInPortHorario;
import com.control.asistencia.application.port.in.horario.command.SaveCommandHorario;
import com.control.asistencia.application.port.out.horario.ISaveOrUpdateOutPortHorario;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;

@UseCase
public class SaveOrUpdateInPortHorario implements ISaveOrUpdateInPortHorario {
    private final ISaveOrUpdateOutPortHorario iSaveOrUpdateOutPortHorario;
    public SaveOrUpdateInPortHorario(ISaveOrUpdateOutPortHorario iSaveOrUpdateOutPortHorario) {
        this.iSaveOrUpdateOutPortHorario = iSaveOrUpdateOutPortHorario;
    }
    @Override
    public ResponseEntity<?> saveOrUpdateHorario(SaveCommandHorario commandHorario) {
        return commandHorario.getIdHorario() > 0
                ? ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortHorario.saveOrUpdateHorario(commandHorario)
                )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortHorario.saveOrUpdateHorario(commandHorario)
        );
    }
}
