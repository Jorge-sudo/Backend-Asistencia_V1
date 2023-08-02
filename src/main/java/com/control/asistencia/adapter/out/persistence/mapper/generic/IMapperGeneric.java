package com.control.asistencia.adapter.out.persistence.mapper.generic;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;
import com.control.asistencia.adapter.out.persistence.entity.RolEntity;
import com.control.asistencia.adapter.out.persistence.entity.SemestreEntity;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import org.mapstruct.*;
import java.util.Set;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperGeneric {
    //@Mapping(source = "campoOrigen", target = "campoDestino")

    //   --------- CARRERA --------------
    @Mappings({
            @Mapping(source = "idCarrera", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SaveCommandGeneric entityToDtoCarrera(CarreraEntity carreraEntity);
    @Mappings({
            @Mapping(source = "id", target = "idCarrera"),
            @Mapping(source = "nombre", target = "nombre")
    })
    CarreraEntity dtoToEntityCarrera(SaveCommandGeneric carreraDTO);
    default Set<SaveCommandGeneric> entitysToDtosCarrera(Set<CarreraEntity> carreraEntity) {
        return carreraEntity
                .stream()
                .map(this::entityToDtoCarrera)
                .collect(java.util.stream.Collectors.toSet());
    }

    //   --------- SEMESTRE --------------
    @Mappings({
            @Mapping(source = "idSemestre", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SaveCommandGeneric entityToDtoSemestre(SemestreEntity semestreEntity);
    @Mappings({
            @Mapping(source = "id", target = "idSemestre"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SemestreEntity dtoToEntitySemestre(SaveCommandGeneric semestreDTO);
    default Set<SaveCommandGeneric> entitysToDtosSemestre(Set<SemestreEntity> semestreEntities) {
        return semestreEntities
                .stream()
                .map(this::entityToDtoSemestre)
                .collect(java.util.stream.Collectors.toSet());
    }

    // --------- ROL --------------
    @Mappings({
            @Mapping(source = "idRol", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    SaveCommandGeneric entityToDtoRol(RolEntity rolEntity);
    default Set<SaveCommandGeneric> entitysToDtosRol(Set<RolEntity> rolEntities) {
        return rolEntities
                .stream()
                .map(this::entityToDtoRol)
                .collect(java.util.stream.Collectors.toSet());
    }
}
