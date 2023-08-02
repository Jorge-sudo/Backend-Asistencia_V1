package com.control.asistencia.application.service.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import com.control.asistencia.application.port.in.semestre.ISaveOrUpdateInPortSemestre;
import com.control.asistencia.application.port.out.semestre.ISaveOrUpdateOutPortSemestre;
import com.control.asistencia.common.UseCase;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplSemestre implements ISaveOrUpdateInPortSemestre {
    private final ISaveOrUpdateOutPortSemestre iSaveOrUpdateOutPortSemestre;
    public SaveOrUpdateInPortImplSemestre(ISaveOrUpdateOutPortSemestre iSaveOrUpdateOutPortSemestre){
        this.iSaveOrUpdateOutPortSemestre = iSaveOrUpdateOutPortSemestre;
    }

    @Override
    public Optional<SaveCommandGeneric> saveOrUpdateSemestre(SaveCommandGeneric saveCommandGeneric) {
        return this.iSaveOrUpdateOutPortSemestre.saveOrUpdateSemestre(saveCommandGeneric);
    }
}
