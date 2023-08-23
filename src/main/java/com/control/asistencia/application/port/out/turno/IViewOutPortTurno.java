package com.control.asistencia.application.port.out.turno;

import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IViewOutPortTurno {
    Optional<List<SaveOrViewCommandGeneric>> viewAllTurno();
}
