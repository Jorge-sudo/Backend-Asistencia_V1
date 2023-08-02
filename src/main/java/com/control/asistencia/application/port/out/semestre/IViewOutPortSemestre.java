package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortSemestre {
    Optional<Set<SaveCommandGeneric>> viewAllSemestreDTO();
}
