package com.control.asistencia.application.service.carrera;

import com.control.asistencia.application.port.in.carrera.IViewServiceCarrera;
import com.control.asistencia.application.port.out.carrera.IViewOutPortCarrera;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;
import java.util.Set;

@UseCase
public class ViewServiceImplCarrera implements IViewServiceCarrera {
    private final IViewOutPortCarrera iViewOutPortCarrera;
    public ViewServiceImplCarrera(IViewOutPortCarrera iViewOutPortCarrera) {
        this.iViewOutPortCarrera = iViewOutPortCarrera;
    }

    @Override
    public Optional<Set<GenericDTO>> viewAllCarreraDTO() {
        return this.iViewOutPortCarrera.viewAllCarreraDTO();
    }
}
