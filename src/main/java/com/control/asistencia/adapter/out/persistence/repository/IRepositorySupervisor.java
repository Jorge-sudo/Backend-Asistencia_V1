package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.SupervisorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorySupervisor
        extends JpaRepository<SupervisorEntity, Long> {
}
