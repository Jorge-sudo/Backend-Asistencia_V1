package com.control.asistencia.application.service.docente;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.docente.IViewInPortDocente;
import com.control.asistencia.application.port.out.docente.IViewOutPortDocente;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@UseCase
public class ViewServiceImplDocente implements  IViewInPortDocente {
    private final IViewOutPortDocente iViewOutPortDocente;

    public ViewServiceImplDocente( IViewOutPortDocente iViewOutPortDocente ) {
        this.iViewOutPortDocente = iViewOutPortDocente;
    }

    @Override
    public Optional<Page<DocenteViewDTO>> viewPageDocenteDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());

        return this.iViewOutPortDocente.viewPageDocenteDTO(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        );
    }

    @Override
    public Optional<DocenteViewDTO> viewByCiDocenteDTO(Long ci) {
        return this.iViewOutPortDocente.viewByCiDocenteDTO(ci);
    }


}
