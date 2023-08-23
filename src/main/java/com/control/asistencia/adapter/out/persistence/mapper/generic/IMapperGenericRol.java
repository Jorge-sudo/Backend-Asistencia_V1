package com.control.asistencia.adapter.out.persistence.mapper.generic;

import com.control.asistencia.adapter.out.persistence.entity.RolEntity;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import org.mapstruct.*;

import java.util.Set;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperGenericRol {
    // --------- ROL --------------
    @Mappings({
            @Mapping(source = "idRol", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SaveOrViewCommandGeneric entityToCommand(RolEntity rolEntity);
    default Set<SaveOrViewCommandGeneric> entitysToCommandsSet(Set<RolEntity> rolEntities) {
        return rolEntities
                .stream()
                .map(this::entityToCommand)
                .collect(java.util.stream.Collectors.toSet());
    }
}
