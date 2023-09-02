package com.control.asistencia.application.port.out.materiaAssignView;

import com.control.asistencia.adapter.out.persistence.entity.view.MateriaAssignView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IViewOutPortMateriaAssignView {
    Page<MateriaAssignView> viewPageMateriaAssignView(Pageable pageable) ;
}
