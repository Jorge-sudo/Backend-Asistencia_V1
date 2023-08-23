package com.control.asistencia.adapter.out.persistence.mapper.supervisor;

import com.control.asistencia.adapter.out.persistence.entity.SupervisorEntity;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperSupervisor {
    @Mappings({
            @Mapping(source = "ci", target = "ci"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "fotografia", target = "fotografia"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "genero", target = "genero"),
            @Mapping(source = "correoInstitucional", target = "correoInstitucional"),
            @Mapping(source = "activo", target = "activo"),
            @Mapping(source = "rol.nombre", target = "rol"),
            @Mapping(source = "reporteEmail", target = "reporteEmail"),
            @Mapping(source = "reporteInstitucional", target = "reporteInstitucional"),
    })
    SupervisorViewDTO entityToDto(SupervisorEntity supervisorEntity);
    default Page<SupervisorViewDTO> entitysToDtosPage(Page<SupervisorEntity> page) {
        return page.map(this::entityToDto);
    }
}
