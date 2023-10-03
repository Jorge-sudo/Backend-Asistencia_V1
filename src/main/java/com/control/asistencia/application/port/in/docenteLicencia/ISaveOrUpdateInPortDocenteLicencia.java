package com.control.asistencia.application.port.in.docenteLicencia;

import com.control.asistencia.application.port.in.docenteLicencia.command.SaveCommandDocenteLicencia;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortDocenteLicencia {
    ResponseEntity<?> saveOrUpdateDocenteLicencia(
            SaveCommandDocenteLicencia saveCommandDocenteLicencia);
}
