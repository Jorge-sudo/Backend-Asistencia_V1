package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryPersona;
import com.control.asistencia.application.port.out.persona.ISaveOrUpdateOutPortPersona;
import com.control.asistencia.application.port.out.persona.IViewOutPortPersona;
import com.control.asistencia.common.PersistenceAdapter;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
public class PersonaPersistenceAdapter implements
        IViewOutPortPersona ,
        ISaveOrUpdateOutPortPersona {
    private final IRepositoryPersona iRepositoryPersona;
    public PersonaPersistenceAdapter(IRepositoryPersona iRepositoryPersona) {
        this.iRepositoryPersona = iRepositoryPersona;
    }

    @Override
    public Optional<PersonaEntity> viewByEmail(String email) {
        return Optional.ofNullable(
                this.iRepositoryPersona.findByNombre(email)
        );
    }

    @Override
    public Optional<PersonaEntity> viewById(Long ci) {
        return this.iRepositoryPersona.findById(ci);
    }

    @Override
    public Optional<PersonaEntity> saveOrUpdatePersona(PersonaEntity personaEntity) {
        return Optional.of(
                this.iRepositoryPersona.save(personaEntity)
        );
    }
}
