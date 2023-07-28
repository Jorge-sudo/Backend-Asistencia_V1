package com.control.asistencia.adapter.out.persistence.repository;


import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryMateriaCarreraSemestre
        extends JpaRepository<MateriaCarreraSemestreEntity, Integer> {
}
