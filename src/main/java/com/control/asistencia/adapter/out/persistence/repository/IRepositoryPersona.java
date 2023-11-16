package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IRepositoryPersona
        extends JpaRepository<PersonaEntity, Long> {
    @Query("SELECT p FROM PersonaEntity p WHERE p.email = :email")
    PersonaEntity findByEmail(String email);
}
