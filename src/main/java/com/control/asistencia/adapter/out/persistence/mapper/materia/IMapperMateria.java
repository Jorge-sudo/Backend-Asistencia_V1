package com.control.asistencia.adapter.out.persistence.mapper.materia;

import com.control.asistencia.adapter.out.persistence.entity.MateriaEntity;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import org.mapstruct.*;
import org.springframework.data.domain.Page;


@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperMateria {
    //@Mapping(source = "campoOrigen", target = "campoDestino")
    @Mappings({
            @Mapping(source = "sigla", target = "sigla"),
            @Mapping(source = "nombre", target = "nombre")
    })
    CommandMateria entityToCommand(MateriaEntity materiaEntity);
    @InheritInverseConfiguration
    MateriaEntity commandToEntity(CommandMateria commandMateria);
    default Page<CommandMateria> entitysToCommandsPage(Page<MateriaEntity> page) {
        return page.map(this::entityToCommand);
    }
}
