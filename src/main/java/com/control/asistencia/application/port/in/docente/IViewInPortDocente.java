package com.control.asistencia.application.port.in.docente;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IViewInPortDocente {
    Optional<Page<DocenteViewDTO>> viewPageDocenteDTO(ViewPageCommand command);
    Optional<DocenteViewDTO> viewByCiDocenteDTO(Long ci);
}
