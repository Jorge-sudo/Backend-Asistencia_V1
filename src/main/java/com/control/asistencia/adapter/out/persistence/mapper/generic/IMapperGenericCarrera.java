package com.control.asistencia.adapter.out.persistence.mapper.generic;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;
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
public interface IMapperGenericCarrera {
    //   --------- CARRERA --------------
    @Mappings({
            @Mapping(source = "idCarrera", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SaveOrViewCommandGeneric entityToCommand(CarreraEntity carreraEntity);
    @InheritInverseConfiguration
    CarreraEntity commandToEntity(SaveOrViewCommandGeneric carreraDTO);
    default Set<SaveOrViewCommandGeneric> entitysToCommandsSet(Set<CarreraEntity> carreraEntity) {
        return carreraEntity
                .stream()
                .map(this::entityToCommand)
                .collect(java.util.stream.Collectors.toSet());
    }
}
