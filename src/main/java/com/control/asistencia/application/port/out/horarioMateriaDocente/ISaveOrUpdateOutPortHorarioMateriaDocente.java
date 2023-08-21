package com.control.asistencia.application.port.out.horarioMateriaDocente;

import com.control.asistencia.application.port.in.asignarMateria.command.CommandHorarioMateriaDocente;

import java.util.Set;

public interface ISaveOrUpdateOutPortHorarioMateriaDocente {
    Set<CommandHorarioMateriaDocente> saveOrUpdateHorarioMateriaDocente(
            Set<CommandHorarioMateriaDocente> commands);
}
