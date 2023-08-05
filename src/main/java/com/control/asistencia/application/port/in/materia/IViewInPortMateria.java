package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IViewInPortMateria {
    Page<CommandMateria> viewPageMateriaDTO(ViewPageCommand command);
    Optional<CommandMateria> viewByIdMateriaDTO(String sigla);
}
