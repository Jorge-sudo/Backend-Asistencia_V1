package com.control.asistencia.adapter.in.web.auth;

import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.config.jwt.JwtGenerador;
import com.control.asistencia.domain.login.LogoutMessageResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
@WebAdapter
@RestController
@RequestMapping("/api/auth")
public class AuthLogoutController {
    private final JwtGenerador jwtGenerador;
    public AuthLogoutController(JwtGenerador jwtGenerador) {
        this.jwtGenerador = jwtGenerador;
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtGenerador.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(
                        LogoutMessageResponse.builder()
                                .message("Cerrar sesión exitoso")
                                .build()
                );
    }
}
