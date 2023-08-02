package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;

public interface ISaveOrUpdateOutPortSemestre {
    Optional<SaveCommandGeneric> saveOrUpdateSemestre(SaveCommandGeneric saveCommandGeneric);
}
