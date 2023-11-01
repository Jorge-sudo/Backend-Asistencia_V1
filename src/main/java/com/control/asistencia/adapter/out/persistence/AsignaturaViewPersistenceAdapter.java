package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.view.AsignaturaView;
import com.control.asistencia.adapter.out.persistence.mapper.AsignaturaView.MapperAsignaturaView;
import com.control.asistencia.adapter.out.persistence.repository.*;
import com.control.asistencia.application.port.in.asignatura.command.CommandPageAssignMateria;
import com.control.asistencia.application.port.out.asignatura.IViewOutPortAsignaturaView;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.util.asistenciaMqtt.AsistenciaFilterTrue;
import org.springframework.data.domain.*;


@PersistenceAdapter
public class AsignaturaViewPersistenceAdapter implements IViewOutPortAsignaturaView {
    private final IRepositoryAsignaturaView iRepositoryAsignaturaView;
    private final AsistenciaFilterTrue asistenciaFilterTrue;
    private final MapperAsignaturaView mapperAsignaturaView;
    public AsignaturaViewPersistenceAdapter(
            IRepositoryAsignaturaView iRepositoryAsignaturaView,
            MapperAsignaturaView mapperAsignaturaView ,
            AsistenciaFilterTrue asistenciaFilterTrue) {

        this.iRepositoryAsignaturaView = iRepositoryAsignaturaView;
        this.mapperAsignaturaView = mapperAsignaturaView;
        this.asistenciaFilterTrue = asistenciaFilterTrue;

    }

    @Override
    public Page<AsignaturaView> viewPageMateriaAssignView(CommandPageAssignMateria command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.DESC : Sort.Direction.ASC ,
                command.getSortField());
        Pageable page = PageRequest.of(command.getPage(), command.getSize(), sort );

        return this.mapperAsignaturaView.fotografiaToBase64Images(this.iRepositoryAsignaturaView.findAll(this.funFilter(command), page));
    }


    private Example<AsignaturaView> funFilter(CommandPageAssignMateria command){
        Example<AsignaturaView> example = null;
        if(this.asistenciaFilterTrue.isPresent(command)){
            example =  this.withSearch(
                    command.getGlobalFilter(),
                    this.asistenciaFilterTrue.getCarrera().getNombre(),
                    this.asistenciaFilterTrue.getSemestre().getNombre(),
                    this.asistenciaFilterTrue.getTurno().getNombre(),
                    this.asistenciaFilterTrue.getDia().getNombre());
        }
        return example;

    }

    private Example<AsignaturaView> withSearch(String search, String carrera,
                                               String semestre, String turno, String dia){
        return Example.of(
                AsignaturaView.builder()
                        .carrera(carrera)
                        .semestre(semestre)
                        .turno(turno)
                        .dia(dia)
                        .apellidoDocente(search)
                        .build(),
                ExampleMatcher.matching() // Cambiar  por matching()
                        .withMatcher("carrera", match -> match.exact().ignoreCase())
                        .withMatcher("semestre", match -> match.exact().ignoreCase())
                        .withMatcher("turno", match -> match.exact().ignoreCase())
                        .withMatcher("dia", match -> match.exact().ignoreCase())
                        .withMatcher("apellidoDocente", match -> match.startsWith().ignoreCase())
                        .withIgnorePaths(
                                "id", "laboratorio",
                                "nroLaboratorio", "activo", "aula", "sigla",
                                "nombre", "nombreDocente", "horario")
        );
    }

}
