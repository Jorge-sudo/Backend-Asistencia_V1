package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.application.port.in.materia.command.SaveCommandMateria;

import java.util.Optional;

public interface ISaveOrUpdateInPortMateria {
    Optional<SaveCommandMateria> saveOrUpdateMateria(SaveCommandMateria saveCommandMateria);
}
