package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import org.springframework.data.domain.Page;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllCommandMateriaCarreraSemestre;
import com.control.asistencia.domain.MateriaCarreraSemestreDTO;

public interface IViewAllOutPortMateriaCarreraSemestre {
    public Page<MateriaCarreraSemestreDTO> getAllMateriaCarreraSemestreDTO(ViewAllCommandMateriaCarreraSemestre viewAllCommandMateriaCarreraSemestre) ;
}
