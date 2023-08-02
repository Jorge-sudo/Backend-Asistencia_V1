package com.control.asistencia.application.service.carrera;

import com.control.asistencia.application.port.in.carrera.IViewInPortCarrera;
import com.control.asistencia.application.port.out.carrera.IViewOutPortCarrera;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

@UseCase
public class ViewInPortImplCarrera implements IViewInPortCarrera {
    private final IViewOutPortCarrera iViewOutPortCarrera;
    public ViewInPortImplCarrera(IViewOutPortCarrera iViewOutPortCarrera) {
        this.iViewOutPortCarrera = iViewOutPortCarrera;
    }

    @Override
    public Optional<Set<SaveCommandGeneric>> viewAllCarreraDTO() {
        return this.iViewOutPortCarrera.viewAllCarreraDTO();
    }
}
