package com.control.asistencia.application.service.licencia;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.licencia.ISaveOrUpdateInPortLicencia;
import com.control.asistencia.application.port.in.licencia.command.CommandSaveOrViewLicencia;
import com.control.asistencia.application.port.out.licencia.ISaveOrUpdateOutPortLicencia;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;

@UseCase
public class SaveOrUpdateInPortLicencia implements ISaveOrUpdateInPortLicencia {
    private final ISaveOrUpdateOutPortLicencia iSaveOrUpdateOutPortLicencia;
    public SaveOrUpdateInPortLicencia(ISaveOrUpdateOutPortLicencia iSaveOrUpdateOutPortLicencia) {
        this.iSaveOrUpdateOutPortLicencia = iSaveOrUpdateOutPortLicencia;
    }
    @Override
    public ResponseEntity<?> saveOrUpdateLicencia(CommandSaveOrViewLicencia command) {
        return command.getId() > 0
                ? ResponseBuilderApiRest.update(
                        this.iSaveOrUpdateOutPortLicencia.saveOrUpdateLicencia(command)
                )
                : ResponseBuilderApiRest.save(
                        this.iSaveOrUpdateOutPortLicencia.saveOrUpdateLicencia(command)
                 );
    }
}
