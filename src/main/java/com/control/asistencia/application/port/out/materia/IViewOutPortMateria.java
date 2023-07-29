package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.domain.materia.MateriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IViewOutPortMateria {
    Optional<Page<MateriaDTO>> viewPageMateriaEntity(Pageable pageable);
    Optional<MateriaDTO> viewByIdMateriaDTO(String sigla);
}
