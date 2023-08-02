package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryPersona
        extends JpaRepository<PersonaEntity, Long> {
}
