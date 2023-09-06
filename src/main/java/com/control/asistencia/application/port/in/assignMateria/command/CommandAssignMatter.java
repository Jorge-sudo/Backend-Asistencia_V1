package com.control.asistencia.application.port.in.assignMateria.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandAssignMatter {
    private CommandMateriaDocente materiaDocente;
    private CommandAulaMateriaDocente aulaMateriaDocente;
    private Set<CommandHorarioMateriaDocente> horarioMateriaDocentes;
}
