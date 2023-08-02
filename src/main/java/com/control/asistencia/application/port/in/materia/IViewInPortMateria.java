package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.materia.command.SaveCommandMateria;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IViewInPortMateria {
    Optional<Page<SaveCommandMateria>> viewPageMateriaDTO(ViewPageCommand command);
    Optional<SaveCommandMateria> viewByIdMateriaDTO(String sigla);
}
