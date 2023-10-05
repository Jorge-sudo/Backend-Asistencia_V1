package com.control.asistencia.adapter.out.persistence.mapper.asistencia;

import com.control.asistencia.adapter.out.persistence.entity.*;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.domain.asistencia.AsistenciaViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.sql.Time;

@Component
public class IMapperAsistenciaDTO {
    private final IViewInPortImagePersona iViewInPortImagePersona;
    public IMapperAsistenciaDTO(IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }
    public AsistenciaViewDTO entityToDto(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }

        AsistenciaViewDTO asistenciaViewDTO = new AsistenciaViewDTO();

        asistenciaViewDTO.setIdAsistencia( asistenciaEntity.getIdAsistencia() );
        asistenciaViewDTO.setHoraEntrada( asistenciaEntity.getHoraEntrada() );
        asistenciaViewDTO.setCantidadEstudiantes( asistenciaEntity.getCantidadEstudiantes() );
        asistenciaViewDTO.setFecha( asistenciaEntity.getFecha() );
        asistenciaViewDTO.setEstadoAsistencia( asistenciaEntity.getEstado() );
        asistenciaViewDTO.setAula( asistenciaEntityAulaEntityAula( asistenciaEntity ) );
        asistenciaViewDTO.setParalelo( asistenciaEntityAulaEntityParalelo( asistenciaEntity ) );
        asistenciaViewDTO.setPiso( asistenciaEntityAulaEntityPiso( asistenciaEntity ) );
        asistenciaViewDTO.setBloque( asistenciaEntityAulaEntityBloque( asistenciaEntity ) );
        asistenciaViewDTO.setNroLaboratorio( asistenciaEntityHorarioMateriaDocenteEntityNroLaboratorio( asistenciaEntity ) );
        asistenciaViewDTO.setLaboratorio( asistenciaEntityHorarioMateriaDocenteEntityLaboratorio( asistenciaEntity ) );
        asistenciaViewDTO.setHoraInicio( asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityHoraInicio( asistenciaEntity ) );
        asistenciaViewDTO.setHoraFin( asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityHoraFin( asistenciaEntity ) );
        asistenciaViewDTO.setDiaSemana( asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityDiaSemanaEntityNombre( asistenciaEntity ) );
        asistenciaViewDTO.setTurno( asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityTurnoEntityNombre( asistenciaEntity ) );
        asistenciaViewDTO.setSigla( asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityMateriaEntitySigla( asistenciaEntity ) );
        asistenciaViewDTO.setNombreMateria( asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityMateriaEntityNombre( asistenciaEntity ) );
        asistenciaViewDTO.setNombreDocente( asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityNombre( asistenciaEntity ) );
        asistenciaViewDTO.setApellidoDocente( asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityApellido( asistenciaEntity ) );

        try {
            asistenciaViewDTO.setBase64ImagenDocente(
                    iViewInPortImagePersona.viewByNameImagePersona(
                            asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityFotografia(asistenciaEntity)
                    )
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return asistenciaViewDTO;
    }

    public Page<AsistenciaViewDTO> entitysToDtosPage(Page<AsistenciaEntity> page) {
        return page.map(this::entityToDto);
    }


    private String asistenciaEntityAulaEntityAula(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        AulaEntity aulaEntity = asistenciaEntity.getAula();
        if ( aulaEntity == null ) {
            return null;
        }
        return aulaEntity.getAula();
    }

    private String asistenciaEntityAulaEntityParalelo(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        AulaEntity aulaEntity = asistenciaEntity.getAula();
        if ( aulaEntity == null ) {
            return null;
        }
        return aulaEntity.getParalelo();
    }

    private String asistenciaEntityAulaEntityPiso(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        AulaEntity aulaEntity = asistenciaEntity.getAula();
        if ( aulaEntity == null ) {
            return null;
        }
        return aulaEntity.getPiso();
    }

    private String asistenciaEntityAulaEntityBloque(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        AulaEntity aulaEntity = asistenciaEntity.getAula();
        if ( aulaEntity == null ) {
            return null;
        }
        return aulaEntity.getBloque();
    }

    private Integer asistenciaEntityHorarioMateriaDocenteEntityNroLaboratorio(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        return horarioMateriaDocenteEntity.getNroLaboratorio();
    }

    private boolean asistenciaEntityHorarioMateriaDocenteEntityLaboratorio(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return false;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return false;
        }
        return horarioMateriaDocenteEntity.isLaboratorio();
    }

    private Time asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityHoraInicio(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horario = horarioMateriaDocenteEntity.getHorario();
        if ( horario == null ) {
            return null;
        }
        return horario.getHoraInicio();
    }

    private Time asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityHoraFin(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horario = horarioMateriaDocenteEntity.getHorario();
        if ( horario == null ) {
            return null;
        }
        return horario.getHoraFin();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityDiaSemanaEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horario = horarioMateriaDocenteEntity.getHorario();
        if ( horario == null ) {
            return null;
        }
        DiaSemanaEntity diaSemana = horario.getDiaSemana();
        if ( diaSemana == null ) {
            return null;
        }
        return diaSemana.getNombre();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityTurnoEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horario = horarioMateriaDocenteEntity.getHorario();
        if ( horario == null ) {
            return null;
        }
        TurnoEntity turnoEntity = horario.getTurno();
        if ( turnoEntity == null ) {
            return null;
        }
        return turnoEntity.getNombre();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityMateriaEntitySigla(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocente = horarioMateriaDocenteEntity.getMateriaDocente();
        if ( materiaDocente == null ) {
            return null;
        }
        MateriaEntity materia = materiaDocente.getMateria();
        if ( materia == null ) {
            return null;
        }
        return materia.getSigla();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityMateriaEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocente = horarioMateriaDocenteEntity.getMateriaDocente();
        if ( materiaDocente == null ) {
            return null;
        }
        MateriaEntity materia = materiaDocente.getMateria();
        if ( materia == null ) {
            return null;
        }
        return materia.getNombre();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocente = horarioMateriaDocenteEntity.getMateriaDocente();
        if ( materiaDocente == null ) {
            return null;
        }
        DocenteEntity docenteEntity = materiaDocente.getDocente();
        if ( docenteEntity == null ) {
            return null;
        }
        return docenteEntity.getNombre();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityApellido(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocente = horarioMateriaDocenteEntity.getMateriaDocente();
        if ( materiaDocente == null ) {
            return null;
        }
        DocenteEntity docenteEntity = materiaDocente.getDocente();
        if ( docenteEntity == null ) {
            return null;
        }
        return docenteEntity.getApellido();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityFotografia(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocente = horarioMateriaDocenteEntity.getMateriaDocente();
        if ( materiaDocente == null ) {
            return null;
        }
        DocenteEntity docenteEntity = materiaDocente.getDocente();
        if ( docenteEntity == null ) {
            return null;
        }
        return docenteEntity.getFotografia();
    }

    protected AulaEntity asistenciaViewDTOToAulaEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        AulaEntity.AulaEntityBuilder aulaEntity = AulaEntity.builder();

        aulaEntity.aula( asistenciaViewDTO.getAula() );
        aulaEntity.paralelo( asistenciaViewDTO.getParalelo() );
        aulaEntity.piso( asistenciaViewDTO.getPiso() );
        aulaEntity.bloque( asistenciaViewDTO.getBloque() );

        return aulaEntity.build();
    }

    protected DiaSemanaEntity asistenciaViewDTOToDiaSemanaEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        DiaSemanaEntity.DiaSemanaEntityBuilder diaSemana = DiaSemanaEntity.builder();

        diaSemana.nombre( asistenciaViewDTO.getDiaSemana() );

        return diaSemana.build();
    }

    protected TurnoEntity asistenciaViewDTOToTurnoEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        TurnoEntity.TurnoEntityBuilder turnoEntity = TurnoEntity.builder();

        turnoEntity.nombre( asistenciaViewDTO.getTurno() );

        return turnoEntity.build();
    }

    protected HorarioEntity asistenciaViewDTOToHorarioEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        HorarioEntity.HorarioEntityBuilder horario = HorarioEntity.builder();

        horario.diaSemana( asistenciaViewDTOToDiaSemanaEntity( asistenciaViewDTO ) );
        horario.turno( asistenciaViewDTOToTurnoEntity( asistenciaViewDTO ) );
        horario.horaInicio( asistenciaViewDTO.getHoraInicio() );
        horario.horaFin( asistenciaViewDTO.getHoraFin() );

        return horario.build();
    }

    protected MateriaEntity asistenciaViewDTOToMateriaEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        MateriaEntity.MateriaEntityBuilder materia = MateriaEntity.builder();

        materia.sigla( asistenciaViewDTO.getSigla() );
        materia.nombre( asistenciaViewDTO.getNombreMateria() );

        return materia.build();
    }

    protected DocenteEntity asistenciaViewDTOToDocenteEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        DocenteEntity.DocenteEntityBuilder<?, ?> docenteEntity = DocenteEntity.builder();

        docenteEntity.nombre( asistenciaViewDTO.getNombreDocente() );
        docenteEntity.apellido( asistenciaViewDTO.getApellidoDocente() );

        return docenteEntity.build();
    }

    protected MateriaDocenteEntity asistenciaViewDTOToMateriaDocenteEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        MateriaDocenteEntity.MateriaDocenteEntityBuilder materiaDocente = MateriaDocenteEntity.builder();

        materiaDocente.materia( asistenciaViewDTOToMateriaEntity( asistenciaViewDTO ) );
        materiaDocente.docente( asistenciaViewDTOToDocenteEntity( asistenciaViewDTO ) );

        return materiaDocente.build();
    }

    protected HorarioMateriaDocenteEntity asistenciaViewDTOToHorarioMateriaDocenteEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        HorarioMateriaDocenteEntity.HorarioMateriaDocenteEntityBuilder horarioMateriaDocenteEntity = HorarioMateriaDocenteEntity.builder();

        horarioMateriaDocenteEntity.horario( asistenciaViewDTOToHorarioEntity( asistenciaViewDTO ) );
        horarioMateriaDocenteEntity.materiaDocente( asistenciaViewDTOToMateriaDocenteEntity( asistenciaViewDTO ) );
        horarioMateriaDocenteEntity.nroLaboratorio( asistenciaViewDTO.getNroLaboratorio() );
        horarioMateriaDocenteEntity.laboratorio( asistenciaViewDTO.isLaboratorio() );

        return horarioMateriaDocenteEntity.build();
    }
}
