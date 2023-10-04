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
    public ResponseEntity<?> viewPageGlobalFilterAsistencia(ViewPageCommand command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                command.getSortField());

        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortAsistencia.viewPageGlobalFilterAsistencia(
                        PageRequest.of(command.getPage(), command.getSize(), sort),
                        command.getGlobalFilter()
                )
        );
    }

    @Override
    public ResponseEntity<?> viewPageFindAllByFechaAsistencia(ViewPageCommand command, String fechaSearch) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                command.getSortField());

        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortAsistencia.viewPageFindAllByFechaAsistencia(
                        PageRequest.of(command.getPage(), command.getSize(), sort),
                        fechaSearch
                )
        );
    }
}
