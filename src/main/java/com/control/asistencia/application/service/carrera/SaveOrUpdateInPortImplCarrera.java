package com.control.asistencia.application.service.carrera;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.carrera.ISaveOrUpdateInPortCarrera;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
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
    public ResponseEntity<?> saveOrUpdateCarrera(SaveOrViewCommandGeneric saveOrViewCommandGeneric) {
        return saveOrViewCommandGeneric.getId() > 0
                ? ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortCarrera.saveOrUpdateCarrera(saveOrViewCommandGeneric)
                )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortCarrera.saveOrUpdateCarrera(saveOrViewCommandGeneric)
                );
    }
}
