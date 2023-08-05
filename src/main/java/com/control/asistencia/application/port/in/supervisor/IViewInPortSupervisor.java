package com.control.asistencia.application.port.in.supervisor;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IViewInPortSupervisor {
    Page<SupervisorViewDTO> viewPageSupervisorDTO(ViewPageCommand command);
    Optional<SupervisorViewDTO> viewByCiSupervisorDTO(Long ci);
}
