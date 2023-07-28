package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCarrera
        extends JpaRepository<CarreraEntity, Integer> {
}
