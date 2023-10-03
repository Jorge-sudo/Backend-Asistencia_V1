package com.control.asistencia.adapter.out.persistence.mapper.licencia;

import com.control.asistencia.adapter.out.persistence.entity.LicenciaEntity;
import com.control.asistencia.application.port.in.licencia.command.CommandSaveOrViewLicencia;
import org.mapstruct.*;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperLicencia {
    @Mappings({
            @Mapping(source = "idLicencia", target = "id"),
            @Mapping(source = "fechaInicio", target = "fechaInicio"),
            @Mapping(source = "fechaFinal", target = "fechaFinal"),
            @Mapping(source = "descripcion", target = "descripcion"),
    })
    CommandSaveOrViewLicencia entityToCommand(LicenciaEntity licenciaEntity);
    @InheritInverseConfiguration
    LicenciaEntity commandToEntity(CommandSaveOrViewLicencia commandSaveOrViewLicencia);
}
