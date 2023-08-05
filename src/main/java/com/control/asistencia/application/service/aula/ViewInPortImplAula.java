package com.control.asistencia.application.service.aula;

import com.control.asistencia.application.port.in.aula.IViewInPortAula;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.out.aula.IViewOutPortAula;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@UseCase
public class ViewInPortImplAula implements
        IViewInPortAula {
    private final IViewOutPortAula iViewOutPortAula;
    public ViewInPortImplAula(IViewOutPortAula iViewOutPortAula){
        this.iViewOutPortAula = iViewOutPortAula;
    }
    @Override
    public Page<CommandAula> viewPageAulaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return this.iViewOutPortAula.viewPageAulaDTO(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        );
    }

    @Override
    public Optional<CommandAula> viewByIdAulaDTO(int idAula) {
        return this.iViewOutPortAula.viewByIdAulaDTO(idAula);
    }
}
