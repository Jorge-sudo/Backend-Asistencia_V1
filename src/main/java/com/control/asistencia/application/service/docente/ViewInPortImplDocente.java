package com.control.asistencia.application.service.docente;

import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.application.port.in.docente.IViewInPortDocente;
import com.control.asistencia.application.port.out.docente.IViewOutPortDocente;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class ViewInPortImplDocente implements  IViewInPortDocente {
    private final IViewOutPortDocente iViewOutPortDocente;

    public ViewInPortImplDocente(IViewOutPortDocente iViewOutPortDocente ) {
        this.iViewOutPortDocente = iViewOutPortDocente;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageDocenteDTO(ViewPageCommand command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.DESC : Sort.Direction.ASC ,
                command.getSortField());

        return ResponseBuilderApiRest.viewPage(this.iViewOutPortDocente.viewPageDocenteDTO(
                command.getGlobalFilter(),
                PageRequest.of(command.getPage(), command.getSize(), sort )
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewByCiDocenteDTO(Long ci) {
        return ResponseBuilderApiRest.view(
                Optional.of(
                        this.iViewOutPortDocente.viewByCiDocenteDTO(ci)
                        .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe el docente con el ci: " + ci))
                )
        );
    }


}
