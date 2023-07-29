package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.domain.materia.MateriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IViewServiceMateria {
    Optional<Page<MateriaDTO>> viewPageMateriaDTO(ViewPageCommand command);
    Optional<MateriaDTO> viewByIdMateriaDTO(String sigla);
}
