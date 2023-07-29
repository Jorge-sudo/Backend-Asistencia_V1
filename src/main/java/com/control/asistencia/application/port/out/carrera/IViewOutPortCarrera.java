package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;

import java.util.Optional;

public interface IViewOutPortCarrera {
    Optional<CarreraEntity> viewByIdCarreraEntity(int id);
}
