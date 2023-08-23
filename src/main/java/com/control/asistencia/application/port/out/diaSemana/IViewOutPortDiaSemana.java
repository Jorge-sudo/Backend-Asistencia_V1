package com.control.asistencia.application.port.out.diaSemana;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.List;
import java.util.Optional;

public interface IViewOutPortDiaSemana {
    Optional<List<SaveOrViewCommandGeneric>> viewAllDiaSemanaDTO();
}
