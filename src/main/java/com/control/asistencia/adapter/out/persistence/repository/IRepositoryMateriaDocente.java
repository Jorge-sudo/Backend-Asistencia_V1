package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.MateriaDocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryMateriaDocente
        extends JpaRepository<MateriaDocenteEntity, Integer> {
}
