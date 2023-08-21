package com.control.asistencia.application.service.aula;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.aula.ISaveOrUpdateInPortAula;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.out.aula.ISaveOrUpdateOutPortAula;
import com.control.asistencia.application.port.out.aula.IViewOutPortAula;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplAula implements
        ISaveOrUpdateInPortAula {
    private final ISaveOrUpdateOutPortAula iSaveOrUpdateOutPortAula;
    private final IViewOutPortAula iViewOutPortAula;
    public SaveOrUpdateInPortImplAula(
            ISaveOrUpdateOutPortAula iSaveOrUpdateOutPortAula ,
            IViewOutPortAula iViewOutPortAula){

        this.iSaveOrUpdateOutPortAula = iSaveOrUpdateOutPortAula;
        this.iViewOutPortAula = iViewOutPortAula;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateAula(CommandAula commandAula) {
        Optional<CommandAula> response = this.iViewOutPortAula
                .viewByIdAulaDTO(commandAula.getId());
        return response.isEmpty()
                ? ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortAula.saveOrUpdateAula(commandAula)
        )
                : ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortAula.saveOrUpdateAula(commandAula)
        );
    }
}
