package com.control.asistencia.config.cross;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://controlasistenciausalesiana.me",
                                "http://localhost:4200",
                                "https://jorge-sudo.github.io/asistencia")
                .allowedMethods("*")
                .maxAge(3600L)
                .allowCredentials(true);
    }
}