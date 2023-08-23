package com.control.asistencia.application.port.out.horario;

import com.control.asistencia.application.port.in.horario.command.SaveCommandHorario;

import java.util.Optional;

public interface ISaveOrUpdateOutPortHorario {
    Optional<SaveCommandHorario> saveOrUpdateHorario(SaveCommandHorario saveCommandHorario);
}
