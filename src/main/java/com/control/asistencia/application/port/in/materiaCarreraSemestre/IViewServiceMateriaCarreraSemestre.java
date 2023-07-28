package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.ViewPageCommandMateriaCarreraSemestre;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface IViewServiceMateriaCarreraSemestre {
    Page<ViewMateriaCarreraSemestreDTO> viewPageMateriaCarreraSemestreDTO(
            ViewPageCommandMateriaCarreraSemestre command);
    Set<ViewMateriaCarreraSemestreDTO> viewAllMateriaCarreraSemestreDTO();
}
