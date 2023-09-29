package com.control.asistencia.application.service.asistencia;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.asistencia.IViewInPortAsistencia;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.out.asistencia.IViewOutPortAsistencia;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

@UseCase
public class ViewInPortImplAsistencia implements IViewInPortAsistencia {
    private final IViewOutPortAsistencia iViewOutPortAsistencia;
    public ViewInPortImplAsistencia(IViewOutPortAsistencia iViewOutPortAsistencia) {
        this.iViewOutPortAsistencia = iViewOutPortAsistencia;
    }
    @Override
    public ResponseEntity<?> viewPageAsistencia(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortField());
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortAsistencia.viewPageAsistencia(
                        PageRequest.of(command.getPage(), command.getSize(), sort)
                )
        );
    }
}
