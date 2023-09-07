package com.control.asistencia.application.service.horario;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.horario.IViewInPortHorario;
import com.control.asistencia.application.port.out.horario.IViewOutPortHorario;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplHorario implements IViewInPortHorario {
    private final IViewOutPortHorario iViewOutPortHorario;
    public ViewInPortImplHorario(IViewOutPortHorario iViewOutPortHorario) {
        this.iViewOutPortHorario = iViewOutPortHorario;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageHorarioDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortHorario.viewPageHorario(
                        PageRequest.of(command.getPage(), command.getSize(), sort
                )
        ));
    }
}
