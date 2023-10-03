package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.DocenteLicenciaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface IRepositoryDocenteLicencia extends
        JpaRepository<DocenteLicenciaEntity, Integer> {
    @Query("SELECT dl FROM DocenteLicenciaEntity dl WHERE dl.licencia.fechaInicio >= :date")
    Page<DocenteLicenciaEntity> findAllAtTheMoment(Date date, Pageable pageable);
    @Query("SELECT dl FROM DocenteLicenciaEntity dl WHERE dl.licencia.fechaInicio < :date")
    Page<DocenteLicenciaEntity> findAllPrevious(Date date, Pageable pageable);
}
