package com.control.asistencia.application.port.out.rol;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortRol {
    Optional<Set<SaveOrViewCommandGeneric>> viewAllRol();
}
