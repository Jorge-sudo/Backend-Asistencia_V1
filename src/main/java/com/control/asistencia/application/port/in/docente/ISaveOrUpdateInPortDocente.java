package com.control.asistencia.application.port.in.docente;

import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
import com.control.asistencia.domain.docente.DocenteViewDTO;

import java.util.Optional;

public interface ISaveOrUpdateInPortDocente {
    Optional<DocenteViewDTO> saveOrUpdateDocente(SaveCommandDocente saveCommandDocente);
}
