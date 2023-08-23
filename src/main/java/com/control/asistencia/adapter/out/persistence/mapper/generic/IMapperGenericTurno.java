package com.control.asistencia.adapter.out.persistence.mapper.generic;

import com.control.asistencia.adapter.out.persistence.entity.TurnoEntity;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperGenericTurno {
    @Mappings({
            @Mapping(source = "idTurno", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SaveOrViewCommandGeneric entityToCommand(TurnoEntity turnoEntity);
    default List<SaveOrViewCommandGeneric> entitysToCommandsList(List<TurnoEntity> turnoEntity) {
        return turnoEntity
                .stream()
                .map(this::entityToCommand)
                .collect(java.util.stream.Collectors.toList());
    }
}
