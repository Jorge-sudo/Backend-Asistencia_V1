package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.application.port.in.materia.command.CommandMateria;

import java.util.Optional;

public interface ISaveOrUpdateInPortMateria {
    Optional<CommandMateria> saveOrUpdateMateria(CommandMateria commandMateria);
}
