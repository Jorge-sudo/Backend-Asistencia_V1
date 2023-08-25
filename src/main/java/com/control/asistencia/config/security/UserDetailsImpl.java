package com.control.asistencia.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
@Getter
@Setter
public class UserDetailsImpl extends User {
    private long id;

    public UserDetailsImpl(long id, String correoInstitucional, String contrasenia, Collection<? extends GrantedAuthority> authorities) {
        super(correoInstitucional, contrasenia, authorities);
        this.id = id;
    }

}
