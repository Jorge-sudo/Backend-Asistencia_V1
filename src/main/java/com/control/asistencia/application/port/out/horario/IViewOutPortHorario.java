package com.control.asistencia.application.port.out.horario;

import com.control.asistencia.domain.horario.HorarioViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortHorario {
    Page<HorarioViewDTO> viewPageHorario(Pageable pageable);
    Optional<Set<HorarioViewDTO>> viewAllHorario();
}
