package com.control.asistencia.application.port.out.aulaMateriaDocente;

import com.control.asistencia.application.port.in.asignatura.command.CommandAulaMateriaDocente;

import java.util.Optional;

public interface ISaveOrUpdateOutPortAulaMateriaDocente {
    Optional<CommandAulaMateriaDocente> saveOrUpdateAulaMateriaDocente(
            CommandAulaMateriaDocente command);
}
