package com.control.asistencia.application.service.docenteLicencia;

import com.control.asistencia.application.port.in.docenteLicencia.ISaveOrUpdateInPortDocenteLicencia;
import com.control.asistencia.application.port.in.docenteLicencia.command.SaveCommandDocenteLicencia;
import com.control.asistencia.application.port.out.docenteLicencia.ISaveOrUpdateOutPortDocenteLicencia;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.http.ResponseEntity;

@UseCase
public class SaveOrUpdateInPortImplDocenteLicencia implements ISaveOrUpdateInPortDocenteLicencia {
    private final ISaveOrUpdateOutPortDocenteLicencia iSaveOrUpdateOutPortDocenteLicencia;
    public SaveOrUpdateInPortImplDocenteLicencia(ISaveOrUpdateOutPortDocenteLicencia iSaveOrUpdateOutPortDocenteLicencia){
        this.iSaveOrUpdateOutPortDocenteLicencia = iSaveOrUpdateOutPortDocenteLicencia;
    }

    @Override
    public ResponseEntity<?> saveOrUpdateDocenteLicencia(SaveCommandDocenteLicencia saveCommandDocenteLicencia) {
        return saveCommandDocenteLicencia.getIdDocenteLicencia() > 0
                ? ResponseBuilderApiRest.update(
                    this.iSaveOrUpdateOutPortDocenteLicencia.saveOrUpdateDocenteLicencia(saveCommandDocenteLicencia)
                )
                : ResponseBuilderApiRest.save(
                    this.iSaveOrUpdateOutPortDocenteLicencia.saveOrUpdateDocenteLicencia(saveCommandDocenteLicencia)
                );
    }
}
