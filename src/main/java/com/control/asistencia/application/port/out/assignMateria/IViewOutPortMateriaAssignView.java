package com.control.asistencia.application.port.out.assignMateria;

import com.control.asistencia.adapter.out.persistence.entity.view.MateriaAssignView;
import com.control.asistencia.application.port.in.assignMateria.command.CommandPageAssignMateria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IViewOutPortMateriaAssignView {
    Page<MateriaAssignView> viewPageMateriaAssignView(CommandPageAssignMateria command) ;
}
