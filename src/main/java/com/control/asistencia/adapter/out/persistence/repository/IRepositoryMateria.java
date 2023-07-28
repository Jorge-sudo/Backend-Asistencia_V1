package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryMateria
        extends JpaRepository<MateriaEntity, String> {
}
