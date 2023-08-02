package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryDocente
        extends JpaRepository<DocenteEntity, Long> {
}
