package com.control.asistencia.application.port.in.materiaAssignView;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortMateriaAssignView {
    ResponseEntity<?> viewPageMateriaAssignView(
            ViewPageCommand command);
}
