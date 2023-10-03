package com.control.asistencia.application.port.out.docenteLicencia;

import com.control.asistencia.application.port.in.docenteLicencia.command.SaveCommandDocenteLicencia;
import com.control.asistencia.domain.docenteLicencia.DocenteLicenciaDTO;

import java.util.Optional;

public interface ISaveOrUpdateOutPortDocenteLicencia {
    Optional<DocenteLicenciaDTO> saveOrUpdateDocenteLicencia(SaveCommandDocenteLicencia command);
}
