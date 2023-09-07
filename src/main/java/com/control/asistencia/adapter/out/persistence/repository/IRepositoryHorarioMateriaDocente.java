package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.HorarioMateriaDocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface IRepositoryHorarioMateriaDocente
        extends JpaRepository<HorarioMateriaDocenteEntity, Integer> {
    @Query("SELECT h FROM HorarioMateriaDocenteEntity h " +
            "WHERE h.materiaDocenteEntity.docenteEntity.ci = :ci" +
            " AND h.horarioEntity.diaSemanaEntity.nombre = :dia")
    Set<HorarioMateriaDocenteEntity> findByDocenteAndDia(Long ci, String dia);
}
