package com.control.asistencia.application.port.out.asignatura;

import com.control.asistencia.adapter.out.persistence.entity.view.AsignaturaView;
import com.control.asistencia.application.port.in.asignatura.command.CommandPageAssignMateria;
import org.springframework.data.domain.Page;


public interface IViewOutPortAsignaturaView {
    Page<AsignaturaView> viewPageMateriaAssignView(CommandPageAssignMateria command) ;
}
