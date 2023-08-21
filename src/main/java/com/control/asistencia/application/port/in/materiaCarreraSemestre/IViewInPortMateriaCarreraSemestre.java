package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortMateriaCarreraSemestre {
    ResponseEntity<?> viewPageMateriaCarreraSemestreDTO(
            ViewPageCommand command);
    ResponseEntity<?>  viewAllMateriaCarreraSemestreDTO();
    ResponseEntity<?>  viewByIdMateriaCarreraSemestreDTO(int id) ;
}
