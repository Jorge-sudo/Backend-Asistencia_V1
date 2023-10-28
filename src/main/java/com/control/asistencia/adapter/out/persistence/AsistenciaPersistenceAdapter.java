package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.*;
import com.control.asistencia.adapter.out.persistence.mapper.asistencia.IMapperAsistenciaCommand;
import com.control.asistencia.adapter.out.persistence.mapper.asistencia.IMapperAsistenciaDTO;
import com.control.asistencia.adapter.out.persistence.repository.*;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import com.control.asistencia.application.port.in.asistencia.command.CommandPageAsistencia;
import com.control.asistencia.application.port.out.asistencia.ISaveOrUpdateOutPortAsistencia;
import com.control.asistencia.application.port.out.asistencia.IViewOutPortAsistencia;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.asistencia.AsistenciaViewDTO;
import com.control.asistencia.domain.mqttAsistencia.MqttMessageResponseNumberEstudiante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.Optional;

@PersistenceAdapter
public class AsistenciaPersistenceAdapter implements
        IViewOutPortAsistencia,
        ISaveOrUpdateOutPortAsistencia {

    private final IRepositoryAsistencia iRepositoryAsistencia;
    private final IRepositoryAula  iRepositoryAula;
    private final IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente;
    private final IMapperAsistenciaDTO iMapperAsistenciaDTO;
    private final IRepositoryCarrera iRepositoryCarrera;
    private final IRepositorySemestre iRepositorySemestre;
    private final IMapperAsistenciaCommand iMapperAsistenciaCommand;
    public AsistenciaPersistenceAdapter(
            IRepositoryAsistencia iRepositoryAsistencia ,
            IMapperAsistenciaDTO iMapperAsistenciaDTO ,
            IRepositoryAula iRepositoryAula ,
            IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente ,
            IMapperAsistenciaCommand iMapperAsistenciaCommand,
            IRepositoryCarrera iRepositoryCarrera,
            IRepositorySemestre iRepositorySemestre){

        this.iRepositoryAsistencia = iRepositoryAsistencia;
        this.iRepositoryAula = iRepositoryAula;
        this.iRepositoryHorarioMateriaDocente = iRepositoryHorarioMateriaDocente;
        this.iMapperAsistenciaDTO = iMapperAsistenciaDTO;
        this.iMapperAsistenciaCommand = iMapperAsistenciaCommand;
        this.iRepositoryCarrera = iRepositoryCarrera;
        this.iRepositorySemestre = iRepositorySemestre;
    }

    @Override
    public Optional<CommandAsistencia> saveOrUpdateAsistencia(CommandAsistencia commandAsistencia) {
        return Optional.of(
                this.iMapperAsistenciaCommand.entityToCommand(
                        this.iRepositoryAsistencia.save(
                                AsistenciaEntity.builder()
                                        .idAsistencia(commandAsistencia.getIdAsistencia())
                                        .horaEntrada(commandAsistencia.getHoraEntrada())
                                        .cantidadEstudiantes(commandAsistencia.getCantidadEstudiantes())
                                        .fecha(commandAsistencia.getFecha())
                                        .estado(commandAsistencia.getEstado())
                                        .aula(
                                                this.iRepositoryAula.findById(commandAsistencia.getIdAula()).orElseThrow(
                                                        () -> new DataNotFoundExceptionMessage(
                                                                "No existe la aula con el ID: " + commandAsistencia.getIdAula()
                                                        )
                                                )
                                        )
                                        .horarioMateriaDocente(
                                                this.iRepositoryHorarioMateriaDocente.findById(commandAsistencia.getIdHorarioMateriaDocente()).orElseThrow(
                                                        () -> new DataNotFoundExceptionMessage(
                                                                "No existe el horarioMateriaDocente con el ID: " + commandAsistencia.getIdHorarioMateriaDocente()
                                                        )
                                                )
                                        )
                                        .build()
                        )
                )
        );
    }

    @Override
    public boolean updateMqttNumberStudentAsistencia(MqttMessageResponseNumberEstudiante message) {
        return this.iRepositoryAsistencia.updateNumberStudentExistAsistencia(
                message.getIdAsistencia(),
                message.getCantEstudiantes()
        );
    }

    @Override
    public Page<AsistenciaViewDTO> viewPageByFechaAndGlobalFilterAsistencia(Pageable pageable, CommandPageAsistencia command) {
        return this.iMapperAsistenciaDTO.entitysToDtosPage(
                this.iRepositoryAsistencia.findAll(
                        this.funFilter(command),
                        pageable
                )
        );
    }


    private Example<AsistenciaEntity> funFilter(CommandPageAsistencia command) {
        Example<AsistenciaEntity> example = null;
        Optional<CarreraEntity> carrera = Optional.ofNullable(
                this.iRepositoryCarrera.findById(command.getIdCarrera()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró la carrera con el id: " + command.getIdCarrera()
                        )
                ));
        Optional<SemestreEntity> semestre = Optional.ofNullable(
                this.iRepositorySemestre.findById(command.getIdSemestre()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró el semestre con el id: " + command.getIdSemestre())
                )
        );

        if (carrera.isPresent()  && semestre.isPresent() ) {
            example = this.withFilter(carrera.get().getNombre(),
                    semestre.get().getNombre(),
                    command.getGlobalFilter(),
                    command.getDateSearch());
        }
        return example;
    }

    private Example<AsistenciaEntity> withFilter(String carrera,
                                                 String semestre,
                                                 String globalFilter,
                                                 String fechaSearch) {
        return Example.of(
                AsistenciaEntity.builder()
                        .fecha(Date.valueOf(fechaSearch))
                        .horarioMateriaDocente(
                                HorarioMateriaDocenteEntity.builder()
                                        .horario(
                                                HorarioEntity.builder()
                                                        .turno(
                                                                TurnoEntity.builder()
                                                                        .nombre(globalFilter)
                                                                .build()
                                                        )
                                                .build()
                                        )
                                        .materiaDocente(
                                                MateriaDocenteEntity.builder()
                                                        .materiaCarreraSemestre(
                                                                MateriaCarreraSemestreEntity.builder()
                                                                        .materia(
                                                                                MateriaEntity.builder()
                                                                                        .nombre(globalFilter)
                                                                                        .sigla(globalFilter)
                                                                                        .build()
                                                                        )
                                                                        .carrera(
                                                                                CarreraEntity.builder()
                                                                                        .nombre(carrera)
                                                                                .build()
                                                                        )
                                                                        .semestre(
                                                                                SemestreEntity.builder()
                                                                                        .nombre(semestre)
                                                                                .build()
                                                                        )
                                                                .build()
                                                        )
                                                        .docente(
                                                                DocenteEntity.builder()
                                                                        .nombre(globalFilter)
                                                                        .apellido(globalFilter)
                                                                        .email(globalFilter)
                                                                .build()
                                                        )
                                                .build()
                                        )
                                .build()
                        )
                .build(),

                ExampleMatcher.matchingAny() // Cambiar  por matching()
                        .withMatcher("aula.aula", match -> match.contains().ignoreCase())
                        .withMatcher("aula.paralelo", match -> match.contains().ignoreCase())
                        .withMatcher("aula.piso", match -> match.contains().ignoreCase())
                        .withMatcher("fecha", match -> match.exact().ignoreCase())
                        .withMatcher("horarioMateriaDocente.horario.diaSemana.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.horario.turno.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.materia.sigla", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.materia.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.docente.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.docente.apellido", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.docente.email", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.materiaCarreraSemestre.carrera.nombre", match -> match.exact().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.materiaCarreraSemestre.semestre.nombre", match -> match.exact().ignoreCase())
                        .withIgnorePaths(
                                "idAsistencia", "horaEntrada",
                                "cantidadEstudiantes", "estado", "aula.idAula","aula.bloque", "aula.aula",
                                "horarioMateriaDocente.idHorarioMateriaDocente", "horarioMateriaDocente.nroLaboratorio",
                                "horarioMateriaDocente.laboratorio", "horarioMateriaDocente.horario.idHorario", "horarioMateriaDocente.horario.horaInicio",
                                "horarioMateriaDocente.horario.horaFin", "horarioMateriaDocente.horario.diaSemana.idDiaSemana",
                                "horarioMateriaDocente.horario.turno.idTurno", "horarioMateriaDocente.materiaDocente.idMateriaDocente",
                                "horarioMateriaDocente.materiaDocente.docente.codRfid", "horarioMateriaDocente.materiaDocente.docente.ci",
                                "horarioMateriaDocente.materiaDocente.docente.fotografia", "horarioMateriaDocente.materiaDocente.docente.genero",
                                "horarioMateriaDocente.materiaDocente.docente.correoInstitucional", "horarioMateriaDocente.materiaDocente.docente.contrasenia",
                                "horarioMateriaDocente.materiaDocente.docente.activo", "horarioMateriaDocente.horario.diaSemana.nombre",
                                "aula.paralelo", "aula.piso")

        );
    }
}
