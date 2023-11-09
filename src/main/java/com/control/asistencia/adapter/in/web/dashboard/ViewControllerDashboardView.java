package com.control.asistencia.adapter.in.web.dashboard;

import com.control.asistencia.application.port.in.dashboard.IViewInPortDashboardView;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerDashboardView {
    private final IViewInPortDashboardView iViewInPortDashboardView;
    public ViewControllerDashboardView(IViewInPortDashboardView iViewInPortDashboardView){
        this.iViewInPortDashboardView = iViewInPortDashboardView;
    }
    @GetMapping(path = "/dashboard")
    ResponseEntity<?> viewADashboardView(){
        return this.iViewInPortDashboardView.viewDashboard();
    }
}
