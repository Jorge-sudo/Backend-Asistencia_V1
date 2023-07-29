package com.control.asistencia.application.service.materia;

import com.control.asistencia.application.port.in.materia.ISaveOrUpdateServiceMateria;
import com.control.asistencia.application.port.out.materia.ISaveOrUpdateOutPortMateria;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.materia.MateriaDTO;

import java.util.Optional;

@UseCase
public class SaveOrUpdateServiceImplMateria implements ISaveOrUpdateServiceMateria {
    private final ISaveOrUpdateOutPortMateria iSaveOrUpdateOutPortMateria;
    public  SaveOrUpdateServiceImplMateria(ISaveOrUpdateOutPortMateria iSaveOrUpdateOutPortMateria){
        this.iSaveOrUpdateOutPortMateria = iSaveOrUpdateOutPortMateria;
    }

    @Override
    public Optional<MateriaDTO> saveOrUpdateMateria(MateriaDTO materiaDTO) {
        return this.iSaveOrUpdateOutPortMateria.saveOrUpdateMateria(materiaDTO);
    }
}
