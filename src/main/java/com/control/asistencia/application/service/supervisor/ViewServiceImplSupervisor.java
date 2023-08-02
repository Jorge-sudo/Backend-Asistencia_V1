package com.control.asistencia.application.service.supervisor;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.supervisor.IViewInPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@UseCase
public class ViewServiceImplSupervisor implements IViewInPortSupervisor {
    private final IViewOutPortSupervisor iViewOutPortSupervisor;
    public ViewServiceImplSupervisor(IViewOutPortSupervisor iViewOutPortSupervisor){
        this.iViewOutPortSupervisor = iViewOutPortSupervisor;
    }

    @Override
    public Optional<Page<SupervisorViewDTO>> viewPageSupervisorDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return this.iViewOutPortSupervisor.viewPageSupervisorDTO(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        );
    }

    @Override
    public Optional<SupervisorViewDTO> viewByCiSupervisorDTO(Long ci) {
        return this.iViewOutPortSupervisor.viewByCiSupervisorDTO(ci);
    }
}
