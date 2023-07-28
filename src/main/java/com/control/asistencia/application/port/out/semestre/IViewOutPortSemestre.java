package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.adapter.out.persistence.entity.SemestreEntity;

public interface IViewOutPortSemestre {
    SemestreEntity viewByIdSemestreEntity(int id);
}
