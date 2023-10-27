package com.control.asistencia.application.port.out.aula;

import com.control.asistencia.application.port.in.aula.command.CommandAula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface IViewOutPortAula {
    Page<CommandAula> viewPageAulaDTO(Pageable pageable);
    Optional<CommandAula> viewByIdAulaDTO(int idAula);
    Optional<Set<CommandAula>> viewAllAulaDTO();
}
