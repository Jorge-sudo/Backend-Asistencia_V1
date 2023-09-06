package com.control.asistencia.adapter.out.persistence.mapper.horario;

import com.control.asistencia.adapter.out.persistence.entity.HorarioEntity;
import com.control.asistencia.application.port.in.horario.command.SaveCommandHorario;
import org.mapstruct.*;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperHorarioCommand {
    @Mappings({
            @Mapping(source = "idHorario", target = "idHorario"),
            @Mapping(source = "horaInicio", target = "horaInicio"),
            @Mapping(source = "horaFin", target = "horaFin"),
            @Mapping(source = "diaSemanaEntity.idDia", target = "idDia"),
            @Mapping(source = "turnoEntity.idTurno", target = "idTurno"),
    })
    SaveCommandHorario entityToCommand(HorarioEntity horarioEntity);
}
