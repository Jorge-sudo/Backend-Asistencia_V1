package com.control.asistencia.application.port.out.rol;

import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortRol {
    Optional<Set<SaveCommandGeneric>> viewAllRol();
}
