package com.control.asistencia.application.service.materiaCarreraSemestre;

import org.springframework.data.domain.Page;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IViewAllOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.MateriaCarreraSemestreDTO;

@UseCase
public class ViewAllMateriaCarreraSemestreService implements ViewAllInPortMateriaCarreraSemestre {
    private final IViewAllOutPortMateriaCarreraSemestre iViewAllOutPortMateriaCarreraSemestre;
    public ViewAllMateriaCarreraSemestreService(IViewAllOutPortMateriaCarreraSemestre iViewAllOutPortMateriaCarreraSemestre){
        this.iViewAllOutPortMateriaCarreraSemestre = iViewAllOutPortMateriaCarreraSemestre;
    }

    @Override
    public Page<MateriaCarreraSemestreDTO> viewAll(ViewAllCommandMateriaCarreraSemestre command) {
        return this.iViewAllOutPortMateriaCarreraSemestre.getAllMateriaCarreraSemestreDTO(command);
    }
    
}
