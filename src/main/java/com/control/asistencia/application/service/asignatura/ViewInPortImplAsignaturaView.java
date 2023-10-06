package com.control.asistencia.application.service.asignatura;

import com.control.asistencia.application.port.in.asignatura.command.CommandPageAssignMateria;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.asignatura.IViewInPortAsignaturaView;
import com.control.asistencia.application.port.out.asignatura.IViewOutPortAsignaturaView;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplAsignaturaView implements IViewInPortAsignaturaView {
    private final IViewOutPortAsignaturaView iViewOutPortAsignaturaView;
    public ViewInPortImplAsignaturaView(IViewOutPortAsignaturaView iViewOutPortAsignaturaView) {
        this.iViewOutPortAsignaturaView = iViewOutPortAsignaturaView;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageMateriaAssignView(CommandPageAssignMateria command) {
        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortAsignaturaView.viewPageMateriaAssignView(command)
        );
    }
}
