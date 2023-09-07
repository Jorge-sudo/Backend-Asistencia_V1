package com.control.asistencia.application.service.materia;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.materia.IViewInPortMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class ViewInPortImplMateria implements IViewInPortMateria {
    private final IViewOutPortMateria iViewOutPortMateria;
    public ViewInPortImplMateria(IViewOutPortMateria iViewOutPortMateria) {
        this.iViewOutPortMateria = iViewOutPortMateria;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageMateriaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortMateria.viewPageMateria(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewByIdMateriaDTO(String sigla) {
        return ResponseBuilderApiRest.view(
                Optional.of(
                        this.iViewOutPortMateria.viewByIdMateriaDTO(sigla)
                        .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la materia con la sigla: " + sigla))
                )
        );
    }
}
