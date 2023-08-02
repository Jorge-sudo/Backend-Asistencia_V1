package com.control.asistencia.application.port.in.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewInPortSemestre {
    Optional<Set<SaveCommandGeneric>> viewAllSemestreDTO();
}
