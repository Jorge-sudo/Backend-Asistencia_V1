package com.control.asistencia.application.port.in.rol;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewInPortRol {
    Optional<Set<SaveOrViewCommandGeneric>> viewAllRol();
}
