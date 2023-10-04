package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;


public interface IRepositoryAsistencia
        extends JpaRepository<AsistenciaEntity, Integer> {

    @Query("SELECT a FROM AsistenciaEntity a WHERE  a.fecha = :fechaSearch")
    Page<AsistenciaEntity> findAllByFecha(Pageable pageable, Date fechaSearch);
    @Query("UPDATE AsistenciaEntity a SET a.cantidadEstudiantes = :cantidadEstudiantes WHERE a.idAsistencia = :idAsistencia")
    boolean updateNumberStudentExistAsistencia(int idAsistencia, int cantidadEstudiantes);
}
