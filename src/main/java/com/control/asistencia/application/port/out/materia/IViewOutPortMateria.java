package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IViewOutPortMateria {
    Page<CommandMateria> viewPageMateria(Pageable pageable);
    Optional<CommandMateria> viewByIdMateriaDTO(String sigla);
}
