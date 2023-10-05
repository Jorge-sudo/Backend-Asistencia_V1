package com.control.asistencia.application.service.aula;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.aula.IViewInPortAula;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.application.port.out.aula.IViewOutPortAula;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


@UseCase
public class ViewInPortImplAula implements
        IViewInPortAula {
    private final IViewOutPortAula iViewOutPortAula;
    public ViewInPortImplAula(IViewOutPortAula iViewOutPortAula){
        this.iViewOutPortAula = iViewOutPortAula;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageAulaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortField());
        return ResponseBuilderApiRest.viewPage(this.iViewOutPortAula.viewPageAulaDTO(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewByIdAulaDTO(int idAula) {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortAula.viewByIdAulaDTO(idAula)
        );
    }
}
