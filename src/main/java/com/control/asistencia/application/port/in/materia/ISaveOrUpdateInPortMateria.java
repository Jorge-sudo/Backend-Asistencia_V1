package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortMateria {
    ResponseEntity<?> saveOrUpdateMateria(CommandMateria commandMateria);
}
