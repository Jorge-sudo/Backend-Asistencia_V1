package com.control.asistencia.adapter.out.persistence.mapper.docente;

import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import com.control.asistencia.adapter.out.persistence.entity.RolEntity;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;


@Component
public class IMapperDocente {
    private final IViewInPortImagePersona iViewInPortImagePersona;
    public IMapperDocente(IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }

    public DocenteViewDTO entityToDto(DocenteEntity docenteEntity) {
        if ( docenteEntity == null ) {
            return null;
        }

        DocenteViewDTO docenteViewDTO = new DocenteViewDTO(
                docenteEntity.getCi(),
                docenteEntity.getNombre(),
                docenteEntity.getApellido(),
                docenteEntity.getFotografia(),
                null,
                docenteEntity.getEmail(),
                docenteEntity.getGenero(),
                docenteEntity.getCorreoInstitucional(),
                docenteEntity.isActivo(),
                supervisorEntityRolNombre(docenteEntity),
                docenteEntity.getCodRfid()
        );

        try {
            docenteViewDTO.setBase64Image(
                    iViewInPortImagePersona.viewByNameImagePersona(docenteEntity.getFotografia())
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return docenteViewDTO;
    }
     public Page<DocenteViewDTO> entitysToDtosPage(Page<DocenteEntity> page) {
        return page.map(this::entityToDto);
     }

    private String supervisorEntityRolNombre(DocenteEntity docenteEntity) {
        if ( docenteEntity == null ) {
            return null;
        }
        RolEntity rol = docenteEntity.getRol();
        if ( rol == null ) {
            return null;
        }
        return rol.getNombre();
    }
}
