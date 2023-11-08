package com.control.asistencia.application.service.aula;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.aula.ISaveOrUpdateInPortAula;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.out.aula.ISaveOrUpdateOutPortAula;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


@UseCase
public class SaveOrUpdateInPortImplAula implements
        ISaveOrUpdateInPortAula {
    private final ISaveOrUpdateOutPortAula iSaveOrUpdateOutPortAula;
    public SaveOrUpdateInPortImplAula(
            ISaveOrUpdateOutPortAula iSaveOrUpdateOutPortAula ){

        this.iSaveOrUpdateOutPortAula = iSaveOrUpdateOutPortAula;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateAula(CommandAula commandAula) {
        return commandAula.getId() > 0
                ? ResponseBuilderApiRest.update(
                    this.iSaveOrUpdateOutPortAula.saveOrUpdateAula(commandAula)
                )
                : ResponseBuilderApiRest.save(
                    this.iSaveOrUpdateOutPortAula.saveOrUpdateAula(commandAula)
                );
    }
}
