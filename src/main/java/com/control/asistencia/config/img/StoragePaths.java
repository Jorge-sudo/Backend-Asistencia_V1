package com.control.asistencia.config.img;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class StoragePaths {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(StoragePaths.class);
    @Bean
    public Path imgDirectory() {
        return Paths.get(System.getProperty("user.dir") + "/uploads");
    }
    @Bean
    public boolean directoryIsExists() {
        return Files.exists(this.imgDirectory());
    }
    @Bean
    public void createDirectoryIsNoTExists() {
        if(!this.directoryIsExists()) {
            try {
                Files.createDirectory(this.imgDirectory());
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
