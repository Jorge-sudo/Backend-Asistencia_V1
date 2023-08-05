package com.control.asistencia.application.port.out.aula;

import com.control.asistencia.application.port.in.aula.command.CommandAula;

import java.util.Optional;

public interface ISaveOrUpdateOutPortAula {
    Optional<CommandAula> saveOrUpdateAula(CommandAula commandAula);
}
