package com.control.asistencia.application.service.assignMateria;

import com.control.asistencia.application.port.in.assignMateria.command.CommandPageAssignMateria;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.assignMateria.IViewInPortMateriaAssignView;
import com.control.asistencia.application.port.out.assignMateria.IViewOutPortMateriaAssignView;
import com.control.asistencia.common.UseCase;
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
    public ResponseEntity<?> viewPageMateriaAssignView(CommandPageAssignMateria command) {
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortMateriaAssignView.viewPageMateriaAssignView(command)
        );
    }
}
