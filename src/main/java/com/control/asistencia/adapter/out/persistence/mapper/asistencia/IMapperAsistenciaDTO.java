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
        AulaEntity aulaEntity = asistenciaEntity.getAulaEntity();
        if ( aulaEntity == null ) {
            return null;
        }
        String aula = aulaEntity.getAula();
        if ( aula == null ) {
            return null;
        }
        return aula;
    }

    private String asistenciaEntityAulaEntityParalelo(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        AulaEntity aulaEntity = asistenciaEntity.getAulaEntity();
        if ( aulaEntity == null ) {
            return null;
        }
        String paralelo = aulaEntity.getParalelo();
        if ( paralelo == null ) {
            return null;
        }
        return paralelo;
    }

    private String asistenciaEntityAulaEntityPiso(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        AulaEntity aulaEntity = asistenciaEntity.getAulaEntity();
        if ( aulaEntity == null ) {
            return null;
        }
        String piso = aulaEntity.getPiso();
        if ( piso == null ) {
            return null;
        }
        return piso;
    }

    private String asistenciaEntityAulaEntityBloque(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        AulaEntity aulaEntity = asistenciaEntity.getAulaEntity();
        if ( aulaEntity == null ) {
            return null;
        }
        String bloque = aulaEntity.getBloque();
        if ( bloque == null ) {
            return null;
        }
        return bloque;
    }

    private Integer asistenciaEntityHorarioMateriaDocenteEntityNroLaboratorio(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        Integer nroLaboratorio = horarioMateriaDocenteEntity.getNroLaboratorio();
        if ( nroLaboratorio == null ) {
            return null;
        }
        return nroLaboratorio;
    }

    private boolean asistenciaEntityHorarioMateriaDocenteEntityLaboratorio(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return false;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return false;
        }
        boolean laboratorio = horarioMateriaDocenteEntity.isLaboratorio();
        return laboratorio;
    }

    private Time asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityHoraInicio(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horarioEntity = horarioMateriaDocenteEntity.getHorarioEntity();
        if ( horarioEntity == null ) {
            return null;
        }
        Time horaInicio = horarioEntity.getHoraInicio();
        if ( horaInicio == null ) {
            return null;
        }
        return horaInicio;
    }

    private Time asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityHoraFin(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horarioEntity = horarioMateriaDocenteEntity.getHorarioEntity();
        if ( horarioEntity == null ) {
            return null;
        }
        Time horaFin = horarioEntity.getHoraFin();
        if ( horaFin == null ) {
            return null;
        }
        return horaFin;
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityDiaSemanaEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horarioEntity = horarioMateriaDocenteEntity.getHorarioEntity();
        if ( horarioEntity == null ) {
            return null;
        }
        DiaSemanaEntity diaSemanaEntity = horarioEntity.getDiaSemanaEntity();
        if ( diaSemanaEntity == null ) {
            return null;
        }
        String nombre = diaSemanaEntity.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityHorarioEntityTurnoEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        HorarioEntity horarioEntity = horarioMateriaDocenteEntity.getHorarioEntity();
        if ( horarioEntity == null ) {
            return null;
        }
        TurnoEntity turnoEntity = horarioEntity.getTurnoEntity();
        if ( turnoEntity == null ) {
            return null;
        }
        String nombre = turnoEntity.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityMateriaEntitySigla(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocenteEntity = horarioMateriaDocenteEntity.getMateriaDocenteEntity();
        if ( materiaDocenteEntity == null ) {
            return null;
        }
        MateriaEntity materiaEntity = materiaDocenteEntity.getMateriaEntity();
        if ( materiaEntity == null ) {
            return null;
        }
        String sigla = materiaEntity.getSigla();
        if ( sigla == null ) {
            return null;
        }
        return sigla;
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityMateriaEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocenteEntity = horarioMateriaDocenteEntity.getMateriaDocenteEntity();
        if ( materiaDocenteEntity == null ) {
            return null;
        }
        MateriaEntity materiaEntity = materiaDocenteEntity.getMateriaEntity();
        if ( materiaEntity == null ) {
            return null;
        }
        String nombre = materiaEntity.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityNombre(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocenteEntity = horarioMateriaDocenteEntity.getMateriaDocenteEntity();
        if ( materiaDocenteEntity == null ) {
            return null;
        }
        DocenteEntity docenteEntity = materiaDocenteEntity.getDocenteEntity();
        if ( docenteEntity == null ) {
            return null;
        }
        String nombre = docenteEntity.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityApellido(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocenteEntity = horarioMateriaDocenteEntity.getMateriaDocenteEntity();
        if ( materiaDocenteEntity == null ) {
            return null;
        }
        DocenteEntity docenteEntity = materiaDocenteEntity.getDocenteEntity();
        if ( docenteEntity == null ) {
            return null;
        }
        String apellido = docenteEntity.getApellido();
        if ( apellido == null ) {
            return null;
        }
        return apellido;
    }

    private String asistenciaEntityHorarioMateriaDocenteEntityMateriaDocenteEntityDocenteEntityFotografia(AsistenciaEntity asistenciaEntity) {
        if ( asistenciaEntity == null ) {
            return null;
        }
        HorarioMateriaDocenteEntity horarioMateriaDocenteEntity = asistenciaEntity.getHorarioMateriaDocenteEntity();
        if ( horarioMateriaDocenteEntity == null ) {
            return null;
        }
        MateriaDocenteEntity materiaDocenteEntity = horarioMateriaDocenteEntity.getMateriaDocenteEntity();
        if ( materiaDocenteEntity == null ) {
            return null;
        }
        DocenteEntity docenteEntity = materiaDocenteEntity.getDocenteEntity();
        if ( docenteEntity == null ) {
            return null;
        }
        String fotografia = docenteEntity.getFotografia();
        if ( fotografia == null ) {
            return null;
        }
        return fotografia;
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

        DiaSemanaEntity.DiaSemanaEntityBuilder diaSemanaEntity = DiaSemanaEntity.builder();

        diaSemanaEntity.nombre( asistenciaViewDTO.getDiaSemana() );

        return diaSemanaEntity.build();
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

        HorarioEntity.HorarioEntityBuilder horarioEntity = HorarioEntity.builder();

        horarioEntity.diaSemanaEntity( asistenciaViewDTOToDiaSemanaEntity( asistenciaViewDTO ) );
        horarioEntity.turnoEntity( asistenciaViewDTOToTurnoEntity( asistenciaViewDTO ) );
        horarioEntity.horaInicio( asistenciaViewDTO.getHoraInicio() );
        horarioEntity.horaFin( asistenciaViewDTO.getHoraFin() );

        return horarioEntity.build();
    }

    protected MateriaEntity asistenciaViewDTOToMateriaEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        MateriaEntity.MateriaEntityBuilder materiaEntity = MateriaEntity.builder();

        materiaEntity.sigla( asistenciaViewDTO.getSigla() );
        materiaEntity.nombre( asistenciaViewDTO.getNombreMateria() );

        return materiaEntity.build();
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

        MateriaDocenteEntity.MateriaDocenteEntityBuilder materiaDocenteEntity = MateriaDocenteEntity.builder();

        materiaDocenteEntity.materiaEntity( asistenciaViewDTOToMateriaEntity( asistenciaViewDTO ) );
        materiaDocenteEntity.docenteEntity( asistenciaViewDTOToDocenteEntity( asistenciaViewDTO ) );

        return materiaDocenteEntity.build();
    }

    protected HorarioMateriaDocenteEntity asistenciaViewDTOToHorarioMateriaDocenteEntity(AsistenciaViewDTO asistenciaViewDTO) {
        if ( asistenciaViewDTO == null ) {
            return null;
        }

        HorarioMateriaDocenteEntity.HorarioMateriaDocenteEntityBuilder horarioMateriaDocenteEntity = HorarioMateriaDocenteEntity.builder();

        horarioMateriaDocenteEntity.horarioEntity( asistenciaViewDTOToHorarioEntity( asistenciaViewDTO ) );
        horarioMateriaDocenteEntity.materiaDocenteEntity( asistenciaViewDTOToMateriaDocenteEntity( asistenciaViewDTO ) );
        horarioMateriaDocenteEntity.nroLaboratorio( asistenciaViewDTO.getNroLaboratorio() );
        horarioMateriaDocenteEntity.laboratorio( asistenciaViewDTO.isLaboratorio() );

        return horarioMateriaDocenteEntity.build();
    }
}
