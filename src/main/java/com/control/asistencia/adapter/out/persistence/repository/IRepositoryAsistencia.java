package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAsistencia
        extends JpaRepository<AsistenciaEntity, Integer> {
}
