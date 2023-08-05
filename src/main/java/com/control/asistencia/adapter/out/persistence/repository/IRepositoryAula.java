package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAula
        extends JpaRepository<AulaEntity, Integer> {
}
