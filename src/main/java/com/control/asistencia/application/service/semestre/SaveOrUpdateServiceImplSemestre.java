package com.control.asistencia.application.service.semestre;

import com.control.asistencia.application.port.in.semestre.ISaveOrUpdateServiceSemestre;
import com.control.asistencia.application.port.out.semestre.ISaveOrUpdateOutPortSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;

@UseCase
public class SaveOrUpdateServiceImplSemestre implements ISaveOrUpdateServiceSemestre {
    private final ISaveOrUpdateOutPortSemestre iSaveOrUpdateOutPortSemestre;
    public  SaveOrUpdateServiceImplSemestre(ISaveOrUpdateOutPortSemestre iSaveOrUpdateOutPortSemestre){
        this.iSaveOrUpdateOutPortSemestre = iSaveOrUpdateOutPortSemestre;
    }

    @Override
    public Optional<GenericDTO> saveOrUpdateSemestre(GenericDTO genericDTO) {
        return this.iSaveOrUpdateOutPortSemestre.saveOrUpdateSemestre(genericDTO);
    }
}
