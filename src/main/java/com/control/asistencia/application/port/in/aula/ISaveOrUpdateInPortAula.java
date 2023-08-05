package com.control.asistencia.application.port.in.aula;

import com.control.asistencia.application.port.in.aula.command.CommandAula;

import java.util.Optional;

public interface ISaveOrUpdateInPortAula {
    Optional<CommandAula> saveOrUpdateAula(CommandAula commandAula);
}
