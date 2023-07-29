package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.adapter.out.persistence.entity.MateriaEntity;

import java.util.Optional;

public interface IViewOutPortMateria {
    Optional<MateriaEntity> viewByIdMateriaEntity(String sigla);
}
