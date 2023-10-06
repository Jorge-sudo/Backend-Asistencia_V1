package com.control.asistencia.adapter.out.persistence.mapper.docenteLicencia;

import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import com.control.asistencia.adapter.out.persistence.entity.DocenteLicenciaEntity;
import com.control.asistencia.adapter.out.persistence.entity.LicenciaEntity;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.domain.docenteLicencia.DocenteLicenciaDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.Date;

@Component
public class MapperDocenteLicencia {


    private final IViewInPortImagePersona iViewInPortImagePersona;
    public MapperDocenteLicencia(IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }

    public Page<DocenteLicenciaDTO> entitysToDtosPage(Page<DocenteLicenciaEntity> page) {
        return page.map(this::entityToDto);
    }

    public DocenteLicenciaDTO entityToDto(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }

        DocenteLicenciaDTO docenteLicenciaDTO = new DocenteLicenciaDTO();

        docenteLicenciaDTO.setIdDocenteLicencia( docenteLicenciaEntity.getIdDocenteLicencia() );
        docenteLicenciaDTO.setFechaInicio( docenteLicenciaEntityLicenciaFechaInicio( docenteLicenciaEntity ) );
        docenteLicenciaDTO.setFechaFinal( docenteLicenciaEntityLicenciaFechaFinal( docenteLicenciaEntity ) );
        docenteLicenciaDTO.setDescripcion( docenteLicenciaEntityLicenciaDescripcion( docenteLicenciaEntity ) );
        docenteLicenciaDTO.setCiDocente( docenteLicenciaEntityDocenteCi( docenteLicenciaEntity ) );
        docenteLicenciaDTO.setNombreDocente( docenteLicenciaEntityDocenteNombre( docenteLicenciaEntity ) );
        docenteLicenciaDTO.setApellidoDocente( docenteLicenciaEntityDocenteApellido( docenteLicenciaEntity ) );

        try {
            docenteLicenciaDTO.setBase64Image(
                    iViewInPortImagePersona.viewByNameImagePersona(docenteLicenciaEntityDocenteFotografia( docenteLicenciaEntity ))
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return docenteLicenciaDTO;
    }

    private Date docenteLicenciaEntityLicenciaFechaInicio(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }
        LicenciaEntity licencia = docenteLicenciaEntity.getLicencia();
        if ( licencia == null ) {
            return null;
        }
        return licencia.getFechaInicio();
    }

    private Date docenteLicenciaEntityLicenciaFechaFinal(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }
        LicenciaEntity licencia = docenteLicenciaEntity.getLicencia();
        if ( licencia == null ) {
            return null;
        }
        return licencia.getFechaFinal();
    }

    private String docenteLicenciaEntityLicenciaDescripcion(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }
        LicenciaEntity licencia = docenteLicenciaEntity.getLicencia();
        if ( licencia == null ) {
            return null;
        }
        return licencia.getDescripcion();
    }

    private Long docenteLicenciaEntityDocenteCi(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }
        DocenteEntity docente = docenteLicenciaEntity.getDocente();
        if ( docente == null ) {
            return null;
        }
        return docente.getCi();
    }

    private String docenteLicenciaEntityDocenteNombre(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }
        DocenteEntity docente = docenteLicenciaEntity.getDocente();
        if ( docente == null ) {
            return null;
        }
        return docente.getNombre();
    }

    private String docenteLicenciaEntityDocenteApellido(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }
        DocenteEntity docente = docenteLicenciaEntity.getDocente();
        if ( docente == null ) {
            return null;
        }
        return docente.getApellido();
    }

    private String docenteLicenciaEntityDocenteFotografia(DocenteLicenciaEntity docenteLicenciaEntity) {
        if ( docenteLicenciaEntity == null ) {
            return null;
        }
        DocenteEntity docente = docenteLicenciaEntity.getDocente();
        if ( docente == null ) {
            return null;
        }
        return docente.getFotografia();
    }
}
