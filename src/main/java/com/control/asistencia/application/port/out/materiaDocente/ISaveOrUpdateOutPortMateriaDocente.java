package com.control.asistencia.application.port.out.materiaDocente;

import com.control.asistencia.application.port.in.assignMateria.command.CommandMateriaDocente;

import java.util.Optional;

public interface ISaveOrUpdateOutPortMateriaDocente {
    Optional<CommandMateriaDocente> saveOrUpdateMateriaDocente(
            CommandMateriaDocente command);
}
