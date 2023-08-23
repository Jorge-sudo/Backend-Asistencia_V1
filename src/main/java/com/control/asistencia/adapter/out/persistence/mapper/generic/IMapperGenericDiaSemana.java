package com.control.asistencia.adapter.out.persistence.mapper.generic;

import com.control.asistencia.adapter.out.persistence.entity.DiaSemanaEntity;
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
public interface IMapperGenericDiaSemana {
    // ---------- DIA SEMANA ---------
    @Mappings({
            @Mapping(source = "idDia", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SaveOrViewCommandGeneric entityToCommand(DiaSemanaEntity diaSemanaEntity);
    default List<SaveOrViewCommandGeneric> entitysToCommandsList(List<DiaSemanaEntity> diaSemanaEntities) {
        return diaSemanaEntities
                .stream()
                .map(this::entityToCommand)
                .collect(java.util.stream.Collectors.toList());
    }
}
