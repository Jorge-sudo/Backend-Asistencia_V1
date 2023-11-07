package com.control.asistencia.config.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JwtSecurityConstants {
    public static final String JWT_COOKIE_NAME = "jwt_access_asistencia";
    public static final long JWT_EXPIRATION_TOKEN = 3600000; //equivaler a 5 min, donde 60000 = a 1 min
    public static final Key JWT_FIRMA = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization"; // Nombre del encabezado HTTP que se utiliza para enviar el token de autenticación
}
