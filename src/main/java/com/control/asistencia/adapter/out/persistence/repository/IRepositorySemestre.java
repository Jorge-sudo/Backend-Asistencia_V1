package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.SemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorySemestre
        extends JpaRepository<SemestreEntity, Integer> {
}
