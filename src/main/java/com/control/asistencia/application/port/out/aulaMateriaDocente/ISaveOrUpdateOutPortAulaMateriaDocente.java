package com.control.asistencia.application.port.out.aulaMateriaDocente;

import com.control.asistencia.application.port.in.assignMateria.command.CommandAulaMateriaDocente;

import java.util.Optional;

public interface ISaveOrUpdateOutPortAulaMateriaDocente {
    Optional<CommandAulaMateriaDocente> saveOrUpdateAulaMateriaDocente(
            CommandAulaMateriaDocente command);
}
