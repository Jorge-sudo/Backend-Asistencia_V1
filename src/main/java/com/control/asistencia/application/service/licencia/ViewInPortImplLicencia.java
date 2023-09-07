package com.control.asistencia.application.service.licencia;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.licencia.IViewInPortLicencia;
import com.control.asistencia.application.port.out.licencia.IViewOutPortLicencia;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplLicencia implements IViewInPortLicencia {
    private final IViewOutPortLicencia iViewOutPortLicencia;
    public ViewInPortImplLicencia(IViewOutPortLicencia iViewOutPortLicencia) {
        this.iViewOutPortLicencia = iViewOutPortLicencia;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageLicenciaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortLicencia.viewPageLicencia(
                        PageRequest.of(command.getPage(), command.getSize(), sort
                )
        ));
    }
}
