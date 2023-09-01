package com.control.asistencia.application.port.out.persona;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;

import java.util.Optional;

public interface ISaveOrUpdateOutPortPersona {
    Optional<PersonaEntity> saveOrUpdatePersona(PersonaEntity personaEntity);
}
