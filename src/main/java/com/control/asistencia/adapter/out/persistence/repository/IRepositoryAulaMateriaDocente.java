package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.AulaMateriaDocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAulaMateriaDocente
        extends JpaRepository<AulaMateriaDocenteEntity, Integer> {
}
