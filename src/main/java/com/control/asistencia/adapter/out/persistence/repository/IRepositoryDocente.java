package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import com.control.asistencia.application.port.in.docente.command.UpdatePerfilCommandDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IRepositoryDocente
        extends JpaRepository<DocenteEntity, Long> {
    @Query("SELECT d FROM DocenteEntity d WHERE d.codRfid = :codRfid")
    DocenteEntity findByCodRfid(String codRfid);
}
