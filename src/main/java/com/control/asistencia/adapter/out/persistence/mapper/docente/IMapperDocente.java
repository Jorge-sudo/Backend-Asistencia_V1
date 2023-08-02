package com.control.asistencia.adapter.out.persistence.mapper.docente;

import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperDocente {
    @Mappings({
            @Mapping(source = "ci", target = "ci"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "fotografia", target = "fotografia"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "genero", target = "genero"),
            @Mapping(source = "correoInstitucional", target = "correoInstitucional"),
            @Mapping(source = "activo", target = "activo"),
            @Mapping(source = "codRfid", target = "codRfid"),
            @Mapping(source = "rol.nombre", target = "rol"),
    })
    DocenteViewDTO entityToDto(DocenteEntity docenteEntity);
    default Page<DocenteViewDTO> pageEntitysToDtos(Page<DocenteEntity> page) {
        return page.map(this::entityToDto);
    }
}
