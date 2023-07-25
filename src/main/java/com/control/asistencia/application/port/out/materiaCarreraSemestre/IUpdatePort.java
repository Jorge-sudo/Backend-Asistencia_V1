package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;

public interface IUpdatePort {
    boolean update(MateriaCarreraSemestreEntity materiaCarreraSemestreEntity);
}
