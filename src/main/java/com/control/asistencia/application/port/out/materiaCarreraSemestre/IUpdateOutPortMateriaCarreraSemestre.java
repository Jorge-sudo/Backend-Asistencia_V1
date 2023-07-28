package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;

public interface IUpdateOutPortMateriaCarreraSemestre {
    boolean update(MateriaCarreraSemestreEntity materiaCarreraSemestreEntity);
}
