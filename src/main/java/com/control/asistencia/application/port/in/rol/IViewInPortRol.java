package com.control.asistencia.application.port.in.rol;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewInPortRol {
    Optional<Set<SaveCommandGeneric>> viewAllRol();
}
