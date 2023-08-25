package com.control.asistencia.config.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class ConstantesSeguridad {
    public static final long JWT_EXPIRATION_TOKEN = 3600000; //equivaler a 5 min, donde 60000 = a 1 min
    public static final Key JWT_FIRMA = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization"; // Nombre del encabezado HTTP que se utiliza para enviar el token de autenticación
}
