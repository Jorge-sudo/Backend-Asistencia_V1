package com.control.asistencia.application.service.materia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.materia.IViewInPortMateria;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@UseCase
public class ViewInPortImplMateria implements IViewInPortMateria {
    private final IViewOutPortMateria iViewOutPortMateria;
    public ViewInPortImplMateria(IViewOutPortMateria iViewOutPortMateria) {
        this.iViewOutPortMateria = iViewOutPortMateria;
    }

    @Override
    public Page<CommandMateria> viewPageMateriaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return this.iViewOutPortMateria.viewPageMateriaEntity(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        );
    }

    @Override
    public Optional<CommandMateria> viewByIdMateriaDTO(String sigla) {
        return this.iViewOutPortMateria.viewByIdMateriaDTO(sigla);
    }
}
