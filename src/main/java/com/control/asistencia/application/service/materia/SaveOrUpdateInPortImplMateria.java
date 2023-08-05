package com.control.asistencia.application.service.materia;

import com.control.asistencia.application.port.in.materia.ISaveOrUpdateInPortMateria;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import com.control.asistencia.application.port.out.materia.ISaveOrUpdateOutPortMateria;
import com.control.asistencia.common.UseCase;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplMateria implements ISaveOrUpdateInPortMateria {
    private final ISaveOrUpdateOutPortMateria iSaveOrUpdateOutPortMateria;
    public SaveOrUpdateInPortImplMateria(ISaveOrUpdateOutPortMateria iSaveOrUpdateOutPortMateria){
        this.iSaveOrUpdateOutPortMateria = iSaveOrUpdateOutPortMateria;
    }

    @Override
    public Optional<CommandMateria> saveOrUpdateMateria(CommandMateria commandMateria) {
        return this.iSaveOrUpdateOutPortMateria.saveOrUpdateMateria(commandMateria);
    }
}
