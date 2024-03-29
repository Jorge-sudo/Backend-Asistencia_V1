package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryPersona;
import com.control.asistencia.application.port.out.user.IViewOutPortUser;
import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@PersistenceAdapter
public class UserPersistenceAdapter  implements IViewOutPortUser {
    private final IRepositoryPersona iRepositoryPersona;
    public UserPersistenceAdapter(IRepositoryPersona iRepositoryPersona) {
        this.iRepositoryPersona = iRepositoryPersona;
    }

    @Override
    @Transactional
    public Optional<PersonaEntity> viewByEmail(String email) {
        return Optional.ofNullable(
                this.iRepositoryPersona.findByEmail(email.trim())
        );
    }
}
