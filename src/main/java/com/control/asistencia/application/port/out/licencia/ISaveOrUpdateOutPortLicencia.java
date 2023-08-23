package com.control.asistencia.application.port.out.licencia;

import com.control.asistencia.application.port.in.licencia.command.CommandSaveOrViewLicencia;

import java.util.Optional;

public interface ISaveOrUpdateOutPortLicencia {
    Optional<CommandSaveOrViewLicencia> saveOrUpdateLicencia(CommandSaveOrViewLicencia commandSaveOrViewLicencia);
}
