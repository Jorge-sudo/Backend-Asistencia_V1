package com.control.asistencia.application.service.semestre;

import com.control.asistencia.application.port.in.semestre.IViewServiceSemestre;
import com.control.asistencia.application.port.out.semestre.IViewOutPortSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.generic.GenericDTO;

import java.util.Optional;
import java.util.Set;

@UseCase
public class ViewServiceImplSemestre implements IViewServiceSemestre {
    private final IViewOutPortSemestre iViewOutPortSemestre;
    public ViewServiceImplSemestre(IViewOutPortSemestre iViewOutPortSemestre) {
        this.iViewOutPortSemestre = iViewOutPortSemestre;
    }

    @Override
    public Optional<Set<GenericDTO>> viewAllSemestreDTO() {
        return this.iViewOutPortSemestre.viewAllSemestreDTO();
    }
}
