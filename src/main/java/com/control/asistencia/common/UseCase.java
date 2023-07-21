package com.control.asistencia.common;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

// Define la anotación personalizada UseCase
@Target({ElementType.TYPE}) // Se aplica solo a elementos de tipo clase
@Retention(RetentionPolicy.RUNTIME) // Está disponible en tiempo de ejecución
@Documented // Se debe documentar en la API
@Component // Es una anotación de componente de Spring
public @interface UseCase {

    // Define el alias value para el atributo value de la anotación Component
    @AliasFor(annotation = Component.class)
    String value() default ""; // Atributo para proporcionar un nombre descriptivo al caso de uso

}
