package com.control.asistencia.application.service.carrera;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.carrera.ISaveOrUpdateInPortCarrera;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import com.control.asistencia.application.port.out.carrera.ISaveOrUpdateOutPortCarrera;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


@UseCase
public class SaveOrUpdateInPortImplCarrera implements ISaveOrUpdateInPortCarrera {
    private final ISaveOrUpdateOutPortCarrera iSaveOrUpdateOutPortCarrera;
    public SaveOrUpdateInPortImplCarrera(ISaveOrUpdateOutPortCarrera iSaveOrUpdateOutPortCarrera){
        this.iSaveOrUpdateOutPortCarrera = iSaveOrUpdateOutPortCarrera;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateCarrera(SaveCommandGeneric saveCommandGeneric) {
        return saveCommandGeneric.getId() > 0
                ? ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortCarrera.saveOrUpdateCarrera(saveCommandGeneric)
                )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortCarrera.saveOrUpdateCarrera(saveCommandGeneric)
                );
    }
}
