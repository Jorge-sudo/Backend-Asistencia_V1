package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.application.port.in.materia.command.CommandMateria;

import java.util.Optional;

public interface ISaveOrUpdateOutPortMateria {
    Optional<CommandMateria> saveOrUpdateMateria(CommandMateria commandMateria);
}
