package com.control.asistencia.application.port.out.materiaDocente;

import com.control.asistencia.application.port.in.asignatura.command.CommandMateriaDocente;

import java.util.Optional;

public interface ISaveOrUpdateOutPortMateriaDocente {
    Optional<CommandMateriaDocente> saveOrUpdateMateriaDocente(
            CommandMateriaDocente command);
}
