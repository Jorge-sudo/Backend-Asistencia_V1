package com.control.asistencia.application.service.semestre;

import com.control.asistencia.application.port.in.semestre.IViewInPortSemestre;
import com.control.asistencia.application.port.out.semestre.IViewOutPortSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.Optional;
import java.util.Set;

@UseCase
public class ViewInPortImplSemestre implements IViewInPortSemestre {
    private final IViewOutPortSemestre iViewOutPortSemestre;
    public ViewInPortImplSemestre(IViewOutPortSemestre iViewOutPortSemestre) {
        this.iViewOutPortSemestre = iViewOutPortSemestre;
    }

    @Override
    public Optional<Set<SaveCommandGeneric>> viewAllSemestreDTO() {
        return this.iViewOutPortSemestre.viewAllSemestreDTO();
    }
}
