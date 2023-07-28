package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.IViewServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.ViewPageCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IViewOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@UseCase
public class ViewServiceImplMateriaCarreraSemestre implements IViewServiceMateriaCarreraSemestre {
    private final IViewOutPortMateriaCarreraSemestre iViewOutPortMateriaCarreraSemestre;
    public ViewServiceImplMateriaCarreraSemestre(IViewOutPortMateriaCarreraSemestre iViewOutPortMateriaCarreraSemestre){
        this.iViewOutPortMateriaCarreraSemestre = iViewOutPortMateriaCarreraSemestre;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ViewMateriaCarreraSemestreDTO> viewPageMateriaCarreraSemestreDTO(ViewPageCommandMateriaCarreraSemestre command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());

        return this.iViewOutPortMateriaCarreraSemestre.viewPagePageMateriaCarreraSemestreDTO(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Set<ViewMateriaCarreraSemestreDTO> viewAllMateriaCarreraSemestreDTO() {
        return this.iViewOutPortMateriaCarreraSemestre.viewAllMateriaCarreraSemestreDTO();
    }
}
