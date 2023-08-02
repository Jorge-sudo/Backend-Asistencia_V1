package com.control.asistencia.application.service.carrera;

import com.control.asistencia.application.port.in.carrera.ISaveOrUpdateInPortCarrera;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import com.control.asistencia.application.port.out.carrera.ISaveOrUpdateOutPortCarrera;
import com.control.asistencia.common.UseCase;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplCarrera implements ISaveOrUpdateInPortCarrera {
    private final ISaveOrUpdateOutPortCarrera iSaveOrUpdateOutPortCarrera;
    public SaveOrUpdateInPortImplCarrera(ISaveOrUpdateOutPortCarrera iSaveOrUpdateOutPortCarrera){
        this.iSaveOrUpdateOutPortCarrera = iSaveOrUpdateOutPortCarrera;
    }

    @Override
    public Optional<SaveCommandGeneric> saveOrUpdateCarrera(SaveCommandGeneric saveCommandGeneric) {
        return this.iSaveOrUpdateOutPortCarrera.saveOrUpdateCarrera(saveCommandGeneric);
    }
}
