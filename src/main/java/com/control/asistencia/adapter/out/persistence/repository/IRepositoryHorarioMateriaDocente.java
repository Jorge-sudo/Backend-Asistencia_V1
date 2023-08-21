package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.HorarioMateriaDocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryHorarioMateriaDocente
        extends JpaRepository<HorarioMateriaDocenteEntity, Integer> {
}
