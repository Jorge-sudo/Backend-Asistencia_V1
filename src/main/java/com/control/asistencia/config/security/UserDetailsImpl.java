package com.control.asistencia.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
@Setter
@Getter
public class UserDetailsImpl extends User {
    private long ci;
    private String name;
    private String role;

    public UserDetailsImpl(
            long ci,
            String name,
            String role,
            String correoInstitucional,
            String contrasenia,
            Collection<? extends GrantedAuthority> authorities) {

        super(correoInstitucional, contrasenia, authorities);
        this.ci = ci;
        this.name = name;
        this.role = role;
    }

}
