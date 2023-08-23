package com.control.asistencia.application.port.out.horario;

import com.control.asistencia.domain.horario.HorarioViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IViewOutPortHorario {
    Page<HorarioViewDTO> viewPageHorario(Pageable pageable);
}
