package com.control.asistencia.application.service.dashboard;

import com.control.asistencia.application.port.in.dashboard.IViewInPortDashboardView;
import com.control.asistencia.application.port.out.dashboard.IViewOutPortDashboardView;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.http.ResponseEntity;

@UseCase
public class ViewInPortImplDashboardView
        implements IViewInPortDashboardView {
    private final IViewOutPortDashboardView iViewOutPortDashboardView;
    public ViewInPortImplDashboardView(IViewOutPortDashboardView iViewOutPortDashboardView) {
        this.iViewOutPortDashboardView = iViewOutPortDashboardView;
    }

    @Override
    public ResponseEntity<?> viewDashboard() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortDashboardView.viewDashboard()
        );
    }
}
