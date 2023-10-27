package com.control.asistencia.adapter.out.persistence.mapper.aula;

import com.control.asistencia.adapter.out.persistence.entity.AulaEntity;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperAula {
    //@Mapping(source = "campoOrigen", target = "campoDestino")
    @Mappings({
            @Mapping(source = "idAula", target = "id"),
            @Mapping(source = "aula", target = "aula"),
            @Mapping(source = "paralelo", target = "paralelo"),
            @Mapping(source = "piso", target = "piso"),
            @Mapping(source = "bloque", target = "bloque"),
    })
    CommandAula entityToCommand(AulaEntity aulaEntity);
    @InheritInverseConfiguration
    AulaEntity dtoToEntity(CommandAula commandAula);
    default Page<CommandAula> entitysToCommandsPage(Page<AulaEntity> page) {
        return page.map(this::entityToCommand);
    }

    default Set<CommandAula> entitysToCommandsSet(List<AulaEntity> aulaEntitys) {
        return  aulaEntitys
                .stream()
                .map(this::entityToCommand)
                .collect(java.util.stream.Collectors.toSet());
    }
}
