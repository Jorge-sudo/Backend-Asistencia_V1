package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.ViewPageCommandMateriaCarreraSemestre;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.Set;

public interface IViewServiceMateriaCarreraSemestre {
    Optional<Page<ViewMateriaCarreraSemestreDTO>> viewPageMateriaCarreraSemestreDTO(
            ViewPageCommandMateriaCarreraSemestre command);
    Optional<Set<ViewMateriaCarreraSemestreDTO>> viewAllMateriaCarreraSemestreDTO();
    Optional<ViewMateriaCarreraSemestreDTO> viewByIdMateriaCarreraSemestreDTO(int id) ;
}
