package com.control.asistencia.application.port.out.supervisor;

import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IViewOutPortSupervisor {
    Page<SupervisorViewDTO> viewPageSupervisorDTO(Pageable pageable);
    Optional<SupervisorViewDTO> viewByCiSupervisorDTO(Long ci);
}
