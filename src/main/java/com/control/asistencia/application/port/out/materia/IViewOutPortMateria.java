package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.adapter.out.persistence.entity.MateriaEntity;

public interface IViewOutPortMateria {
    MateriaEntity viewByIdMateriaEntity(String sigla);
}
