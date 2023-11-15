package com.control.asistencia.config.security;

import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.application.port.out.persona.IViewOutPortPersona;
import com.control.asistencia.application.port.out.user.IViewOutPortUser;
import jakarta.transaction.Transactional;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUsersDetailsService implements UserDetailsService {


    private final IViewOutPortUser iViewOutPortUser;
    private final IViewInPortImagePersona iViewInPortImagePersona;

    public CustomUsersDetailsService(
            IViewOutPortUser iViewOutPortUser,
            IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewOutPortUser = iViewOutPortUser;
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }

    // Método para cargar los detalles del usuario a partir del correo institucional
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String base64Image = "";
        if(this.iViewOutPortUser.viewByEmail(username).isPresent()){
            PersonaEntity persona = this.iViewOutPortUser.viewByEmail(username).get();
            try {
                base64Image = this.iViewInPortImagePersona.viewByNameImagePersona(persona.getFotografia());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            authorities.add(new SimpleGrantedAuthority(persona.getRol().getNombre()));
            // Crea y devuelve un objeto User de Spring Security con el correo institucional, la contraseña y las autoridades del usuario
            return new UserDetailsImpl(
                    persona.getCi(),
                    persona.getNombre() + " " + persona.getApellido(),
                    persona.getRol().getNombre(),
                    base64Image,
                    persona.getEmail(),
                    persona.getContrasenia(),
                    authorities);
        }
        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}