package com.control.asistencia.application.service.carrera;

import com.control.asistencia.application.port.in.carrera.ISaveOrUpdateServiceCarrera;
import com.control.asistencia.application.port.out.carrera.ISaveOrUpdateOutPortCarrera;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;

@UseCase
public class SaveOrUpdateServiceImplCarrera implements ISaveOrUpdateServiceCarrera {
    private final ISaveOrUpdateOutPortCarrera iSaveOrUpdateOutPortCarrera;
    public  SaveOrUpdateServiceImplCarrera(ISaveOrUpdateOutPortCarrera iSaveOrUpdateOutPortCarrera){
        this.iSaveOrUpdateOutPortCarrera = iSaveOrUpdateOutPortCarrera;
    }

    @Override
    public Optional<GenericDTO> saveOrUpdateCarrera(GenericDTO genericDTO) {
        return this.iSaveOrUpdateOutPortCarrera.saveOrUpdateCarrera(genericDTO);
    }
}
