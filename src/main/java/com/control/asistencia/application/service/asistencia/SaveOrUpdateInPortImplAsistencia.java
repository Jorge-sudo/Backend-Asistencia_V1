package com.control.asistencia.application.service.asistencia;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.asistencia.ISaveOrUpdateInPortAsistencia;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import com.control.asistencia.application.port.out.asistencia.ISaveOrUpdateOutPortAsistencia;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;


@UseCase
public class SaveOrUpdateInPortImplAsistencia implements ISaveOrUpdateInPortAsistencia {
    private final ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia;
    public SaveOrUpdateInPortImplAsistencia(ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia) {
        this.iSaveOrUpdateOutPortAsistencia = iSaveOrUpdateOutPortAsistencia;
    }

    @Override
    public ResponseEntity<?> saveOrUpdateAsistencia(CommandAsistencia command) {
        return command.getIdAsistencia() > 0
                ? ResponseBuilderApiRest.update(
                    this.iSaveOrUpdateOutPortAsistencia.saveOrUpdateAsistencia(command)
                )
                : ResponseBuilderApiRest.save(
                    this.iSaveOrUpdateOutPortAsistencia.saveOrUpdateAsistencia(command)
                );
    }
}
