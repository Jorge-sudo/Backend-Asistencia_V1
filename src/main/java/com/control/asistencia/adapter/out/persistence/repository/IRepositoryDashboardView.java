package com.control.asistencia.adapter.out.persistence.repository;

import com.control.asistencia.adapter.out.persistence.entity.view.DashboardView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryDashboardView
        extends JpaRepository<DashboardView, Integer> {
}
