package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.Optional;

public interface ISaveOrUpdateOutPortSemestre {
    Optional<SaveOrViewCommandGeneric> saveOrUpdateSemestre(SaveOrViewCommandGeneric saveOrViewCommandGeneric);
}
