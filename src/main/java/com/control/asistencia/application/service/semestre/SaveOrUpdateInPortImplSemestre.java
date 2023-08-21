package com.control.asistencia.application.service.semestre;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import com.control.asistencia.application.port.in.semestre.ISaveOrUpdateInPortSemestre;
import com.control.asistencia.application.port.out.semestre.ISaveOrUpdateOutPortSemestre;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class SaveOrUpdateInPortImplSemestre implements ISaveOrUpdateInPortSemestre {
    private final ISaveOrUpdateOutPortSemestre iSaveOrUpdateOutPortSemestre;
    public SaveOrUpdateInPortImplSemestre(ISaveOrUpdateOutPortSemestre iSaveOrUpdateOutPortSemestre){
        this.iSaveOrUpdateOutPortSemestre = iSaveOrUpdateOutPortSemestre;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateSemestre(SaveCommandGeneric saveCommandGeneric) {
        return saveCommandGeneric.getId() > 0
                ? ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortSemestre.saveOrUpdateSemestre(saveCommandGeneric)
        )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortSemestre.saveOrUpdateSemestre(saveCommandGeneric)
        );
    }
}
