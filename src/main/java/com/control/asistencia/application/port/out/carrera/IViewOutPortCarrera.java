package com.control.asistencia.application.port.out.carrera;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;

public interface IViewOutPortCarrera {
    CarreraEntity viewByIdCarreraEntity(int id);
}
