package com.control.asistencia.application.port.out.materiaCarreraSemestre;

import com.control.asistencia.domain.materiaCarreraSemestre.MateriaCarreraSemestreViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortMateriaCarreraSemestre {
    Page<MateriaCarreraSemestreViewDTO> viewPageMateriaCarreraSemestreDTO(
            String globalFilter, Pageable pageable) ;
    Optional<Set<MateriaCarreraSemestreViewDTO>> viewAllMateriaCarreraSemestreDTO() ;
    Optional<MateriaCarreraSemestreViewDTO> viewByIdMateriaCarreraSemestreDTO(int id) ;
}
