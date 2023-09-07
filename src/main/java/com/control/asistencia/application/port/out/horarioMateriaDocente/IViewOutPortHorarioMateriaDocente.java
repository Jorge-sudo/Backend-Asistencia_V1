package com.control.asistencia.application.port.out.horarioMateriaDocente;

import com.control.asistencia.domain.horarioMateriaDocente.HorarioMateriaDocenteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface IViewOutPortHorarioMateriaDocente {
    Page<HorarioMateriaDocenteDTO> viewPageHorarioMateriaDocenteDTO(Pageable pageable);
    Set<HorarioMateriaDocenteDTO> viewByDocenteAndDiaDTO(Long ci, String dia);
}
