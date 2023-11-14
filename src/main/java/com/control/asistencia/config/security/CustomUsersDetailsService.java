package com.control.asistencia.config.security;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import com.control.asistencia.application.port.out.persona.IViewOutPortPersona;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUsersDetailsService implements UserDetailsService {

    private final IViewOutPortPersona iViewOutPortPersona;

    public CustomUsersDetailsService(IViewOutPortPersona iViewOutPortPersona){
        this.iViewOutPortPersona = iViewOutPortPersona;
    }

    // Método para cargar los detalles del usuario a partir del correo institucional
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(this.iViewOutPortPersona.viewByEmail(username).isPresent()){
            PersonaEntity persona = this.iViewOutPortPersona.viewByEmail(username).get();
            authorities.add(new SimpleGrantedAuthority(persona.getRol().getNombre()));
            // Crea y devuelve un objeto User de Spring Security con el correo institucional, la contraseña y las autoridades del usuario
            return new UserDetailsImpl(
                    persona.getCi(),
                    persona.getNombre() + " " + persona.getApellido(),
                    persona.getRol().getNombre(),
                    persona.getEmail(),
                    persona.getContrasenia(),
                    authorities);
        }
        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}