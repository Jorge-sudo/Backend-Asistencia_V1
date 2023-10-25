package com.control.asistencia.adapter.out.persistence.repository;


import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface IRepositoryMateriaCarreraSemestre
        extends JpaRepository<MateriaCarreraSemestreEntity, Integer> {
    @Query("SELECT m FROM MateriaCarreraSemestreEntity m WHERE m.materia.sigla = :sigla")
    Set<MateriaCarreraSemestreEntity> findBySigla(String sigla);
}
