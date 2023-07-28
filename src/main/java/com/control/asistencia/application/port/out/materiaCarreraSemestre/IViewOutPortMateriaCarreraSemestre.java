package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface IViewOutPortMateriaCarreraSemestre {
    Page<ViewMateriaCarreraSemestreDTO> viewPagePageMateriaCarreraSemestreDTO(Pageable pageable) ;
    Set<ViewMateriaCarreraSemestreDTO> viewAllMateriaCarreraSemestreDTO() ;
}
