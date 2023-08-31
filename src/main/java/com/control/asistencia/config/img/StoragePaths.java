package com.control.asistencia.config.img;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class StoragePaths {
    @Bean
    public Path imgDirectory() {
        return Paths.get(System.getProperty("user.dir") + "/uploads");
    }
}
