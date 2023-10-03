package com.control.asistencia.application.service.docenteLicencia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.docenteLicencia.IViewInPortDocenteLicencia;
import com.control.asistencia.application.port.out.docenteLicencia.IViewOutPortDocenteLicencia;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@UseCase
public class ViewInPortImplDocenteLicencia implements
        IViewInPortDocenteLicencia  {
    private final IViewOutPortDocenteLicencia iViewOutPortDocenteLicencia;
    public ViewInPortImplDocenteLicencia(IViewOutPortDocenteLicencia iViewOutPortDocenteLicencia ) {
        this.iViewOutPortDocenteLicencia = iViewOutPortDocenteLicencia;
    }
    @Override
    public ResponseEntity<?> viewPageActiveDocenteLicenciaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                command.getSortField());
        return ResponseBuilderApiRest.view(
                Optional.of(
                        this.iViewOutPortDocenteLicencia.viewPageActiveDocenteLicenciaDTO(
                                PageRequest.of(command.getPage(), command.getSize(), sort )
                        )
                )
        );
    }

    @Override
    public ResponseEntity<?> viewPageInactiveDocenteLicenciaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                command.getSortField());
        return ResponseBuilderApiRest.view(
                Optional.of(
                        this.iViewOutPortDocenteLicencia.viewPageInactiveDocenteLicenciaDTO(
                                PageRequest.of(command.getPage(), command.getSize(), sort )
                        )
                )
        );
    }

    @Override
    public ResponseEntity<?> viewPageFilterGlobalDocenteLicenciaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                command.getSortField());
        return ResponseBuilderApiRest.view(
                Optional.of(
                        this.iViewOutPortDocenteLicencia.viewPageFilterGlobalDocenteLicenciaDTO(
                                PageRequest.of(command.getPage(), command.getSize(), sort ),
                                command.getGlobalFilter()
                        )
                )
        );
    }

}
