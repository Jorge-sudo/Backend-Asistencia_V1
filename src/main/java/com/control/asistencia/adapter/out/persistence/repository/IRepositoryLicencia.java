package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.LicenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryLicencia
        extends JpaRepository<LicenciaEntity, Integer> {
}
