package com.control.asistencia.adapter.in.web.auth;

import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.config.jwt.JwtGenerador;
import com.control.asistencia.domain.login.LoginRequest;
import com.control.asistencia.domain.login.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api/auth")
public class AuthLoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtGenerador jwtGenerador;
    public AuthLoginController(
            AuthenticationManager authenticationManager,
            JwtGenerador jwtGenerador) {

        this.authenticationManager = authenticationManager;
        this.jwtGenerador = jwtGenerador;
    }
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getContrasenia()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(
                new LoginResponse(
                        jwtGenerador.generarToken(authentication)
                ), HttpStatus.OK);
    }
}
