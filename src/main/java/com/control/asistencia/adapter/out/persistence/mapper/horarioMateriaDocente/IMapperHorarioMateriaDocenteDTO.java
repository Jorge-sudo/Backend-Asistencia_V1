package com.control.asistencia.adapter.out.persistence.mapper.horarioMateriaDocente;

import com.control.asistencia.adapter.out.persistence.entity.HorarioMateriaDocenteEntity;
import com.control.asistencia.domain.horarioMateriaDocente.HorarioMateriaDocenteDTO;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperHorarioMateriaDocenteDTO {
    @Mappings({
            @Mapping(source = "idHorarioMateriaDocente", target = "idHorarioMateriaDocente"),
            @Mapping(source = "laboratorio", target = "laboratorio"),
            @Mapping(source = "nroLaboratorio", target = "nroLaboratorio"),
            @Mapping(source = "horario.horaInicio", target = "horaInicio"),
            @Mapping(source = "horario.horaFin", target = "horaFin"),
            @Mapping(source = "horario.diaSemana.nombre", target = "dia"),
            @Mapping(source = "horario.turno.nombre", target = "turno"),
            @Mapping(source = "materiaDocente.materiaCarreraSemestre.materia.sigla", target = "sigla"),
            @Mapping(source = "materiaDocente.materiaCarreraSemestre.materia.nombre", target = "materia"),
            @Mapping(source = "materiaDocente.docente.nombre", target = "nombreDocente"),
            @Mapping(source = "materiaDocente.docente.apellido", target = "apellidoDocente"),
    })
    HorarioMateriaDocenteDTO entityToDto(HorarioMateriaDocenteEntity entity);
    default Page<HorarioMateriaDocenteDTO> entitysToDtosPage(Page<HorarioMateriaDocenteEntity> page) {
        return page.map(this::entityToDto);
    }
    default Set<HorarioMateriaDocenteDTO> entitysToDtosSet(Set<HorarioMateriaDocenteEntity> set) {
        return set.stream().map(this::entityToDto).collect(Collectors.toSet());
    }
}
