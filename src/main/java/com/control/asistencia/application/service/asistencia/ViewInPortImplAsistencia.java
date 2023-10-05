package com.control.asistencia.application.service.asistencia;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.asistencia.IViewInPortAsistencia;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.application.port.out.asistencia.IViewOutPortAsistencia;
import com.control.asistencia.common.UseCase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

@UseCase
public class ViewInPortImplAsistencia implements IViewInPortAsistencia {
    private final IViewOutPortAsistencia iViewOutPortAsistencia;
    public ViewInPortImplAsistencia(IViewOutPortAsistencia iViewOutPortAsistencia) {
        this.iViewOutPortAsistencia = iViewOutPortAsistencia;
    }
    @Override
    public ResponseEntity<?> viewPageGlobalFilterAsistencia(ViewPageCommand command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                this.getShortFieldAsistencia(command.getSortField()));

        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortAsistencia.viewPageGlobalFilterAsistencia(
                        PageRequest.of(command.getPage(), command.getSize(), sort),
                        command.getGlobalFilter()
                )
        );
    }

    @Override
    public ResponseEntity<?> viewPageFindAllByFechaAsistencia(ViewPageCommand command, String fechaSearch) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                this.getShortFieldAsistencia(command.getSortField()));

        return ResponseBuilderApiRest.viewPage(
                this.iViewOutPortAsistencia.viewPageFindAllByFechaAsistencia(
                        PageRequest.of(command.getPage(), command.getSize(), sort),
                        fechaSearch
                )
        );
    }

    private String getShortFieldAsistencia(String shortField){
        return switch (shortField) {
            case "fotografia" -> "horarioMateriaDocente.materiaDocente.docente.fotografia";
            case "nombreDocente"   -> "horarioMateriaDocente.materiaDocente.docente.nombre";
            case "apellidoDocente"  -> "horarioMateriaDocente.materiaDocente.docente.apellido";
            case "estadoAsistencia"  -> "estado";
            case "aula"  -> "aula.aula";
            case "laboratorio"  -> "horarioMateriaDocente.laboratorio";
            case "horario"  -> "horarioMateriaDocente.horario.diaSemana.nombre";
            case "nombreMateria"  -> "horarioMateriaDocente.materiaDocente.materia.nombre";
            default        -> shortField;
        };
    }
}
