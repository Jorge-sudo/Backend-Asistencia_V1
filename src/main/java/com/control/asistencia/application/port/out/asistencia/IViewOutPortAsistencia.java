package com.control.asistencia.application.port.out.asistencia;

import com.control.asistencia.application.port.in.asistencia.command.CommandPageAsistencia;
import com.control.asistencia.domain.asistencia.AsistenciaViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IViewOutPortAsistencia {
    Page<AsistenciaViewDTO> viewPageByFechaAndGlobalFilterAsistencia(Pageable pageable, CommandPageAsistencia command);
}
