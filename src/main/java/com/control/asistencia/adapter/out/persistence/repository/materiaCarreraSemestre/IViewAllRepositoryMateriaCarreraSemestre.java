package com.control.asistencia.adapter.out.persistence.repository.materiaCarreraSemestre;


import org.springframework.data.domain.Page;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllCommandMateriaCarreraSemestre;

public interface IViewAllRepositoryMateriaCarreraSemestre {
    Page<MateriaCarreraSemestreEntity> getMateriaCarreraSemestreEntitys(ViewAllCommandMateriaCarreraSemestre viewAllCommandMateriaCarreraSemestre);
}
