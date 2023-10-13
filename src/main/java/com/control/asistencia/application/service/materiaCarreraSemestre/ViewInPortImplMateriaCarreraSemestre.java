package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.IViewInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IViewOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class ViewInPortImplMateriaCarreraSemestre implements IViewInPortMateriaCarreraSemestre {
    private final IViewOutPortMateriaCarreraSemestre iViewOutPortMateriaCarreraSemestre;
    public ViewInPortImplMateriaCarreraSemestre(IViewOutPortMateriaCarreraSemestre iViewOutPortMateriaCarreraSemestre){
        this.iViewOutPortMateriaCarreraSemestre = iViewOutPortMateriaCarreraSemestre;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewPageMateriaCarreraSemestreDTO(ViewPageCommand command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.DESC : Sort.Direction.ASC ,
                this.getShortFieldMateriaCarreraSemestre(command.getSortField()));

        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortMateriaCarreraSemestre.viewPageMateriaCarreraSemestreDTO(
                        command.getGlobalFilter(),
                        PageRequest.of(command.getPage(), command.getSize(), sort )
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?>  viewAllMateriaCarreraSemestreDTO() {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortMateriaCarreraSemestre.viewAllMateriaCarreraSemestreDTO()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?>  viewByIdMateriaCarreraSemestreDTO(int id) {
        return ResponseBuilderApiRest.view(
                this.iViewOutPortMateriaCarreraSemestre.viewByIdMateriaCarreraSemestreDTO(id)
        );
    }

    private String getShortFieldMateriaCarreraSemestre(String shortField){
        return switch (shortField) {
            case "sigla" -> "materia.sigla";
            case "materia"   -> "materia.nombre";
            case "carrera"  -> "carrera.nombre";
            case "semestre"  -> "semestre.nombre";
            default        -> shortField;
        };
    }
}
