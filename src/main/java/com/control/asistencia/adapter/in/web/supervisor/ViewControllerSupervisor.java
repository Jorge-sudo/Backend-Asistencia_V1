package com.control.asistencia.adapter.in.web.supervisor;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.supervisor.IViewInPortSupervisor;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerSupervisor {
    private final IViewInPortSupervisor iViewInPortSupervisor;
    public ViewControllerSupervisor(IViewInPortSupervisor iViewInPortSupervisor){
        this.iViewInPortSupervisor = iViewInPortSupervisor;
    }
    @GetMapping("/supervisores/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageSupervisor(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy ){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return ResponseBuilderApiRest.viewPage(
                this.iViewInPortSupervisor.viewPageSupervisorDTO(command)
        );

    }
    @GetMapping("/supervisores/{ci}")
    ResponseEntity<?> viewByCiSupervisor(
            @PathVariable("ci") long ci){

        return ResponseBuilderApiRest.view(
                this.iViewInPortSupervisor.viewByCiSupervisorDTO(ci)
        );

    }
}
