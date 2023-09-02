package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortMateriaCarreraSemestre {
    Page<ViewMateriaCarreraSemestreDTO> viewPageMateriaCarreraSemestreDTO(Pageable pageable) ;
    Optional<Set<ViewMateriaCarreraSemestreDTO>> viewAllMateriaCarreraSemestreDTO() ;
    Optional<ViewMateriaCarreraSemestreDTO> viewByIdMateriaCarreraSemestreDTO(int id) ;
}
