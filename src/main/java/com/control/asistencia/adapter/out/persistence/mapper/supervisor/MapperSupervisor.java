package com.control.asistencia.adapter.out.persistence.mapper.supervisor;

import com.control.asistencia.adapter.out.persistence.entity.RolEntity;
import com.control.asistencia.adapter.out.persistence.entity.SupervisorEntity;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperSupervisor {
    private final IViewInPortImagePersona iViewInPortImagePersona;
    public MapperSupervisor(IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }

    public SupervisorViewDTO entityToDto(SupervisorEntity supervisorEntity) {
        if ( supervisorEntity == null ) {
            return null;
        }

        SupervisorViewDTO supervisorViewDTO = new SupervisorViewDTO(
                supervisorEntity.getCi(),
                supervisorEntity.getNombre(),
                supervisorEntity.getApellido(),
                supervisorEntity.getFotografia(),
                null,
                supervisorEntity.getEmail(),
                supervisorEntity.getGenero(),
                supervisorEntity.getCorreoInstitucional(),
                supervisorEntity.isActivo(),
                supervisorEntityRolNombre(supervisorEntity),
                supervisorEntity.isReporteEmail(),
                supervisorEntity.isReporteInstitucional()
        );

        try {
            supervisorViewDTO.setBase64Image(
                    iViewInPortImagePersona.viewByNameImagePersona(supervisorEntity.getFotografia())
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return supervisorViewDTO;
    };


    public Set<SupervisorViewDTO> entitysToDtosSet(List<SupervisorEntity> set) {
        return set.stream().map(this::entityToDto).collect(Collectors.toSet());
    }

    private String supervisorEntityRolNombre(SupervisorEntity supervisorEntity) {
        if ( supervisorEntity == null ) {
            return null;
        }
        RolEntity rol = supervisorEntity.getRol();
        if ( rol == null ) {
            return null;
        }
        return rol.getNombre();
    }
}
