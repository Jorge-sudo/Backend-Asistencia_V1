package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryHorario
        extends JpaRepository<HorarioEntity, Integer> {
}
