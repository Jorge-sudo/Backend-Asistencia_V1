package com.control.asistencia.application.service.materiaAssignView;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.materiaAssignView.IViewInPortMateriaAssignView;
import com.control.asistencia.application.port.out.materiaAssignView.IViewOutPortMateriaAssignView;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplMateriaAssignView implements IViewInPortMateriaAssignView {
    private final IViewOutPortMateriaAssignView iViewOutPortMateriaAssignView;
    public ViewInPortImplMateriaAssignView(IViewOutPortMateriaAssignView iViewOutPortMateriaAssignView) {
        this.iViewOutPortMateriaAssignView = iViewOutPortMateriaAssignView;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageMateriaAssignView(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortMateriaAssignView.viewPageMateriaAssignView(
                        PageRequest.of(command.getPage(), command.getSize(), sort )
                ));
    }
}
