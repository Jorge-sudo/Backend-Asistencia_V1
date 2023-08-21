package com.control.asistencia.application.service.supervisor;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.supervisor.IViewInPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplSupervisor implements IViewInPortSupervisor {
    private final IViewOutPortSupervisor iViewOutPortSupervisor;
    public ViewInPortImplSupervisor(IViewOutPortSupervisor iViewOutPortSupervisor){
        this.iViewOutPortSupervisor = iViewOutPortSupervisor;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageSupervisorDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortSupervisor.viewPageSupervisorDTO(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewByCiSupervisorDTO(Long ci) {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortSupervisor.viewByCiSupervisorDTO(ci)
        );
    }
}
