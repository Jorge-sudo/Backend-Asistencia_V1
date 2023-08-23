package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortSemestre {
    Optional<Set<SaveOrViewCommandGeneric>> viewAllSemestreDTO();
}
