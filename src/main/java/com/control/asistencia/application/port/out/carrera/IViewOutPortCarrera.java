package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.List;
import java.util.Optional;

public interface IViewOutPortCarrera {
    Optional<List<SaveOrViewCommandGeneric>> viewAllCarreraDTO();

}
