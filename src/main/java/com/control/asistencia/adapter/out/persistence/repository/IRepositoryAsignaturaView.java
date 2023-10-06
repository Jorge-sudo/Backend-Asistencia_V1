package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.view.AsignaturaView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAsignaturaView
        extends JpaRepository<AsignaturaView, Integer> {
}
