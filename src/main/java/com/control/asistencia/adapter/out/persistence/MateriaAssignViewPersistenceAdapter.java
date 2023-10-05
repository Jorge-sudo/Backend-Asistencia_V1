package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;
import com.control.asistencia.adapter.out.persistence.entity.DiaSemanaEntity;
import com.control.asistencia.adapter.out.persistence.entity.SemestreEntity;
import com.control.asistencia.adapter.out.persistence.entity.TurnoEntity;
import com.control.asistencia.adapter.out.persistence.entity.view.MateriaAssignView;
import com.control.asistencia.adapter.out.persistence.repository.*;
import com.control.asistencia.application.port.in.assignMateria.command.CommandPageAssignMateria;
import com.control.asistencia.application.port.out.assignMateria.IViewOutPortMateriaAssignView;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import org.springframework.data.domain.*;

import java.util.Optional;

@PersistenceAdapter
public class MateriaAssignViewPersistenceAdapter implements IViewOutPortMateriaAssignView {
    private final IRepositoryMateriaAssignView iRepositoryMateriaAssignView;
    private final IRepositoryCarrera iRepositoryCarrera;
    private final IRepositoryTurno iRepositoryTurno;
    private final IRepositorySemestre iRepositorySemestre;
    private final IRepositoryDiaSemana iRepositoryDiaSemana;
    public MateriaAssignViewPersistenceAdapter(
            IRepositoryMateriaAssignView iRepositoryMateriaAssignView,
            IRepositoryCarrera iRepositoryCarrera,
            IRepositoryTurno iRepositoryTurno,
            IRepositorySemestre iRepositorySemestre,
            IRepositoryDiaSemana iRepositoryDiaSemana) {

        this.iRepositoryMateriaAssignView = iRepositoryMateriaAssignView;
        this.iRepositoryCarrera = iRepositoryCarrera;
        this.iRepositoryTurno = iRepositoryTurno;
        this.iRepositorySemestre = iRepositorySemestre;
        this.iRepositoryDiaSemana = iRepositoryDiaSemana;

    }

    @Override
    public Page<MateriaAssignView> viewPageMateriaAssignView(CommandPageAssignMateria command) {
        Sort sort = Sort.by(
                command.getShortOrder() == 1 ? Sort.Direction.ASC : Sort.Direction.DESC ,
                command.getSortField());
        Pageable page = PageRequest.of(command.getPage(), command.getSize(), sort );

        return this.iRepositoryMateriaAssignView.findAll(this.funFilter(command), page);
    }


    private Example<MateriaAssignView> funFilter(CommandPageAssignMateria command){
        Example<MateriaAssignView> example = null;
        Optional<CarreraEntity> carrera = Optional.ofNullable(
                this.iRepositoryCarrera.findById(command.getIdCarrera()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró la carrera con el id: " + command.getIdCarrera()
                        )
                ));
        Optional<TurnoEntity> turno = Optional.ofNullable(
                this.iRepositoryTurno.findById(command.getIdTurno()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró el turno con el id: " + command.getIdTurno() )
                )
        );
        Optional<SemestreEntity> semestre = Optional.ofNullable(
                this.iRepositorySemestre.findById(command.getIdSemestre()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró el semestre con el id: " + command.getIdSemestre() )
                )
        );
        Optional<DiaSemanaEntity> dia = Optional.ofNullable(
                this.iRepositoryDiaSemana.findById(command.getIdDia()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró el día con el id: " + command.getIdDia() )
                )
        );

        if(command.getGlobalFilter() == null){
            if(carrera.isPresent() && turno.isPresent() && semestre.isPresent() && dia.isPresent()){
                example =  this.outOfSearch(carrera.get().getNombre(),
                        semestre.get().getNombre(), turno.get().getNombre(), dia.get().getNombre());
            }


        }else{
            if(carrera.isPresent() && turno.isPresent() && semestre.isPresent() && dia.isPresent()){
                example =  this.withSearch(command.getGlobalFilter(), carrera.get().getNombre(),
                        semestre.get().getNombre(), turno.get().getNombre(), dia.get().getNombre());
            }
        }
        return example;

    }

    private Example<MateriaAssignView> withSearch(String search, String carrera,
                                                  String semestre, String turno, String dia){
        return Example.of(
                MateriaAssignView.builder()
                        .carrera(carrera)
                        .semestre(semestre)
                        .turno(turno)
                        .dia(dia)
                        .horario(search)
                        .build(),
                ExampleMatcher.matching() // Cambiar  por matching()
                        .withMatcher("carrera", match -> match.exact().ignoreCase())
                        .withMatcher("semestre", match -> match.exact().ignoreCase())
                        .withMatcher("turno", match -> match.exact().ignoreCase())
                        .withMatcher("dia", match -> match.exact().ignoreCase())
                        .withMatcher("horario", match -> match.startsWith().ignoreCase())
                        .withIgnorePaths(
                                "id", "laboratorio",
                                "nroLaboratorio", "activo", "aula", "sigla",
                                "nombre", "nombreDocente", "apellidoDocente")
        );
    }

    private Example<MateriaAssignView> outOfSearch(String carrera, String semestre,
                                                   String turno, String dia){
        return Example.of(
                MateriaAssignView.builder()
                        .carrera(carrera)
                        .semestre(semestre)
                        .turno(turno)
                        .dia(dia)
                        .build(),
                ExampleMatcher.matching() // Cambiar  por matching()
                        .withMatcher("carrera", match -> match.exact().ignoreCase())
                        .withMatcher("semestre", match -> match.exact().ignoreCase())
                        .withMatcher("turno", match -> match.exact().ignoreCase())
                        .withMatcher("dia", match -> match.exact().ignoreCase())
                        .withIgnorePaths(
                                "id", "laboratorio",
                                "nroLaboratorio", "activo", "aula",
                                "sigla", "nombre", "nombreDocente",
                                "apellidoDocente", "horario")
        );
    }
}
