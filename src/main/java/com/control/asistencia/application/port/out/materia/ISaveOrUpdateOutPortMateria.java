package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.application.port.in.materia.command.SaveCommandMateria;

import java.util.Optional;

public interface ISaveOrUpdateOutPortMateria {
    Optional<SaveCommandMateria> saveOrUpdateMateria(SaveCommandMateria saveCommandMateria);
}
