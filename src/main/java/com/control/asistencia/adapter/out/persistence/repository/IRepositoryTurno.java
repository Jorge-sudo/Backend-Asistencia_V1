package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryTurno
        extends JpaRepository<TurnoEntity, Integer> {
}
