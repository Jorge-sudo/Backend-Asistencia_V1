package com.control.asistencia.application.port.in.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;

public interface ISaveOrUpdateInPortSemestre {
    Optional<SaveCommandGeneric> saveOrUpdateSemestre(SaveCommandGeneric saveCommandGeneric);
}
