package com.control.asistencia.application.port.out.dashboard;

import com.control.asistencia.adapter.out.persistence.entity.view.DashboardView;

import java.util.Optional;

public interface IViewOutPortDashboardView {
    Optional<DashboardView> viewDashboard();
}
