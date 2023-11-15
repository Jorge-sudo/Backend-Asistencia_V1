package com.control.asistencia.application.port.out.user;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;

import java.util.Optional;

public interface IViewOutPortUser {
    Optional<PersonaEntity> viewByEmail(String email);
}
