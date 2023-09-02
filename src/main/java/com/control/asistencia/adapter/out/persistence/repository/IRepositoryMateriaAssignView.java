package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.view.MateriaAssignView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryMateriaAssignView
        extends JpaRepository<MateriaAssignView, Integer> {
}
