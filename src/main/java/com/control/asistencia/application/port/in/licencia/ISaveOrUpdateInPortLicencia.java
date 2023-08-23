package com.control.asistencia.application.port.in.licencia;

import com.control.asistencia.application.port.in.licencia.command.CommandSaveOrViewLicencia;
import org.springframework.http.ResponseEntity;


public interface ISaveOrUpdateInPortLicencia {
    ResponseEntity<?> saveOrUpdateLicencia(CommandSaveOrViewLicencia commandSaveOrViewLicencia);
}
