package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.view.DashboardView;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDashboardView;
import com.control.asistencia.application.port.out.dashboard.IViewOutPortDashboardView;
import com.control.asistencia.common.PersistenceAdapter;

import java.util.Optional;

@PersistenceAdapter
public class DashboardViewPersistenceAdapter
        implements IViewOutPortDashboardView {
    private final IRepositoryDashboardView iRepositoryDashboardView;
    public DashboardViewPersistenceAdapter(IRepositoryDashboardView iRepositoryDashboardView) {
        this.iRepositoryDashboardView = iRepositoryDashboardView;
    }

    @Override
    public Optional<DashboardView> viewDashboard() {
        return this.iRepositoryDashboardView.findById(1);
    }
}
