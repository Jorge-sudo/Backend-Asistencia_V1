package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.*;
import com.control.asistencia.adapter.out.persistence.mapper.asistencia.IMapperAsistenciaCommand;
import com.control.asistencia.adapter.out.persistence.mapper.asistencia.IMapperAsistenciaDTO;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryAsistencia;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryAula;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryHorarioMateriaDocente;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
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
    private final IMapperAsistenciaCommand iMapperAsistenciaCommand;
    public AsistenciaPersistenceAdapter(
            IRepositoryAsistencia iRepositoryAsistencia ,
            IMapperAsistenciaDTO iMapperAsistenciaDTO ,
            IRepositoryAula iRepositoryAula ,
            IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente ,
            IMapperAsistenciaCommand iMapperAsistenciaCommand){

        this.iRepositoryAsistencia = iRepositoryAsistencia;
        this.iRepositoryAula = iRepositoryAula;
        this.iRepositoryHorarioMateriaDocente = iRepositoryHorarioMateriaDocente;
        this.iMapperAsistenciaDTO = iMapperAsistenciaDTO;
        this.iMapperAsistenciaCommand = iMapperAsistenciaCommand;
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
    public Page<AsistenciaViewDTO> viewPageGlobalFilterAsistencia(Pageable pageable, String globalFilter) {
        return this.iMapperAsistenciaDTO.entitysToDtosPage(
                this.iRepositoryAsistencia.findAll(
                        this.funFilterGlobal(globalFilter),
                        pageable
                )
        );
    }

    @Override
    public Page<AsistenciaViewDTO> viewPageFindAllByFechaAsistencia(Pageable pageable, String fechaSearch) {
        return this.iMapperAsistenciaDTO.entitysToDtosPage(
                this.iRepositoryAsistencia.findAllByFecha(
                        pageable,
                        Date.valueOf(fechaSearch)
                )
        );
    }

    private Example<AsistenciaEntity> funFilterGlobal(String globalFilter) {
        return Example.of(
                AsistenciaEntity.builder()
                        .aula(
                                AulaEntity.builder()
                                        .aula(globalFilter)
                                        .paralelo(globalFilter)
                                        .piso(globalFilter)
                                .build()
                        )
                        .horarioMateriaDocente(
                                HorarioMateriaDocenteEntity.builder()
                                        .horario(
                                                HorarioEntity.builder()
                                                        .diaSemana(
                                                                DiaSemanaEntity.builder()
                                                                        .nombre(globalFilter)
                                                                .build()
                                                        )
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
                        .withMatcher("asistencia.aula.aula", match -> match.contains().ignoreCase())
                        .withMatcher("asistencia.aula.paralelo", match -> match.contains().ignoreCase())
                        .withMatcher("asistencia.aula.piso", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.horario.diaSemana.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.horario.turno.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.materia.sigla", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.materia.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.docente.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.docente.apellido", match -> match.contains().ignoreCase())
                        .withMatcher("horarioMateriaDocente.materiaDocente.docente.email", match -> match.contains().ignoreCase())
                        .withIgnorePaths(
                                "idAsistencia", "horaEntrada",
                                "cantidadEstudiantes", "fecha", "estado", "aula.idAula","aula.bloque",
                                "horarioMateriaDocente.idHorarioMateriaDocente", "horarioMateriaDocente.nroLaboratorio",
                                "horarioMateriaDocente.laboratorio", "horarioMateriaDocente.horario.idHorario", "horarioMateriaDocente.horario.horaInicio",
                                "horarioMateriaDocente.horario.horaFin", "horarioMateriaDocente.horario.diaSemana.idDiaSemana",
                                "horarioMateriaDocente.horario.turno.idTurno", "horarioMateriaDocente.materiaDocente.idMateriaDocente",
                                "horarioMateriaDocente.materiaDocente.docente.codRfid", "horarioMateriaDocente.materiaDocente.docente.ci",
                                "horarioMateriaDocente.materiaDocente.docente.fotografia", "horarioMateriaDocente.materiaDocente.docente.genero",
                                "horarioMateriaDocente.materiaDocente.docente.correoInstitucional", "horarioMateriaDocente.materiaDocente.docente.contrasenia",
                                "horarioMateriaDocente.materiaDocente.docente.activo")
        );
    }
}
