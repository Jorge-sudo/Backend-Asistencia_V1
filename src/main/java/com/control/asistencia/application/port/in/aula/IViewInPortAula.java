package com.control.asistencia.application.port.in.aula;

import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IViewInPortAula {
    Page<CommandAula> viewPageAulaDTO(ViewPageCommand command);
    Optional<CommandAula> viewByIdAulaDTO(int idAula);
}
