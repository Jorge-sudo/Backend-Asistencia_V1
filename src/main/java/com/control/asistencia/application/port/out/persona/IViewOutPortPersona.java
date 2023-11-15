package com.control.asistencia.application.port.out.persona;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;

import java.util.Optional;

public interface IViewOutPortPersona {
    Optional<PersonaEntity> viewById(Long ci);
}
