package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryPersona;
import com.control.asistencia.application.port.in.persona.command.UpdatePasswordPersona;
import com.control.asistencia.application.port.out.persona.ISaveOrUpdateOutPortPersona;
import com.control.asistencia.application.port.out.persona.IUpdatePasswordOutPortPersona;
import com.control.asistencia.application.port.out.persona.IViewOutPortPersona;
import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@PersistenceAdapter
public class PersonaPersistenceAdapter implements
        IViewOutPortPersona ,
        ISaveOrUpdateOutPortPersona ,
        IUpdatePasswordOutPortPersona {
    private final IRepositoryPersona iRepositoryPersona;
    private final PasswordEncoder passwordEncoder;
    public PersonaPersistenceAdapter(
            IRepositoryPersona iRepositoryPersona,
            PasswordEncoder passwordEncoder) {
        this.iRepositoryPersona = iRepositoryPersona;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<PersonaEntity> viewById(Long ci) {
        return this.iRepositoryPersona.findById(ci);
    }

    @Override
    public void saveOrUpdatePersona(PersonaEntity personaEntity) {
        this.iRepositoryPersona.save(personaEntity);
    }

    @Override
    public boolean updatePassword(UpdatePasswordPersona command) {
        boolean result = false;
        Optional<PersonaEntity> personaEntity = this.iRepositoryPersona.findById(command.getCi());
        if (personaEntity.isPresent()) {
            if(this.passwordEncoder.matches(command.getContrasenia(), personaEntity.get().getContrasenia())){
                personaEntity.get().setContrasenia(this.passwordEncoder.encode(command.getContraseniaNueva()));
                this.iRepositoryPersona.save(personaEntity.get());
                result = true;
            }
        }
        return result;
    }
}
