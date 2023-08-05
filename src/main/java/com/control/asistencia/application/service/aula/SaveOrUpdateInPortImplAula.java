package com.control.asistencia.application.service.aula;

import com.control.asistencia.application.port.in.aula.ISaveOrUpdateInPortAula;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.out.aula.ISaveOrUpdateOutPortAula;
import com.control.asistencia.common.UseCase;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplAula implements
        ISaveOrUpdateInPortAula {
    private final ISaveOrUpdateOutPortAula iSaveOrUpdateOutPortAula;
    public SaveOrUpdateInPortImplAula(ISaveOrUpdateOutPortAula iSaveOrUpdateOutPortAula){
        this.iSaveOrUpdateOutPortAula = iSaveOrUpdateOutPortAula;
    }

    @Override
    public Optional<CommandAula> saveOrUpdateAula(CommandAula commandAula) {
        return this.iSaveOrUpdateOutPortAula.saveOrUpdateAula(commandAula);
    }
}
