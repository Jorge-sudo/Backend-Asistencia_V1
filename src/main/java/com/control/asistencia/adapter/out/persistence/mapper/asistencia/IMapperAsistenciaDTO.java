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
    HorarioMateriaDocenteEntity horarioMateriaDocenteEntity;
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
        this.horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        MateriaDocenteEntity materiaDocente = horarioMateriaDocenteEntity.getMateriaDocente();
        if ( materiaDocente == null ) {
            return null;
        }
        MateriaEntity materia = materiaDocente.getMateriaCarreraSemestre().getMateria();
        if ( materia == null ) {
            return null;
        }
        return materia.getSigla();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityMateriaEntityNombre(AsistenciaEntity asistenciaEntity) {
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocente = horarioMateriaDocenteEntity.getMateriaDocente();
        if ( materiaDocente == null ) {
            return null;
        }
        MateriaEntity materia = materiaDocente.getMateriaCarreraSemestre().getMateria();
        if ( materia == null ) {
            return null;
        }
        return materia.getNombre();
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityNombre(AsistenciaEntity asistenciaEntity) {
        this.horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
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
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocente();
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
}
