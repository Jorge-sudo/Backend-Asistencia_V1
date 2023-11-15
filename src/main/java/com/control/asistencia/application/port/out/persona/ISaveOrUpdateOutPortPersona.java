package com.control.asistencia.application.port.out.persona;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;

public interface ISaveOrUpdateOutPortPersona {
    void saveOrUpdatePersona(PersonaEntity personaEntity);
}
