package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryRol
        extends JpaRepository<RolEntity, Integer> {
}
