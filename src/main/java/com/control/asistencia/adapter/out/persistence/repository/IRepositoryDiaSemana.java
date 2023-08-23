package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.DiaSemanaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryDiaSemana
        extends JpaRepository<DiaSemanaEntity, Integer> {

}
