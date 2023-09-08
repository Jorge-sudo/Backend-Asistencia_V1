package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRepositoryAsistencia
        extends JpaRepository<AsistenciaEntity, Integer> {
    @Query("UPDATE AsistenciaEntity a SET a.cantidadEstudiantes = :cantidadEstudiantes WHERE a.idAsistencia = :idAsistencia")
    boolean updateNumberStudentExistAsistencia(int idAsistencia, int cantidadEstudiantes);
}
