package com.control.asistencia.application.port.out.semestre;

import com.control.asistencia.adapter.out.persistence.entity.SemestreEntity;

import java.util.Optional;

public interface IViewOutPortSemestre {
    Optional<SemestreEntity> viewByIdSemestreEntity(int id);
}
