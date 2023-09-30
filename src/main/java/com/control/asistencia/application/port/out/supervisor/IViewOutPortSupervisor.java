package com.control.asistencia.application.port.out.supervisor;

import com.control.asistencia.domain.supervisor.SupervisorViewDTO;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortSupervisor {
    Set<SupervisorViewDTO> viewSetSupervisorDTO();
    Optional<SupervisorViewDTO> viewByCiSupervisorDTO(Long ci);
}
