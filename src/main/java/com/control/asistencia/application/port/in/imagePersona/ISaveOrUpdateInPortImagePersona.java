package com.control.asistencia.application.port.in.imagePersona;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ISaveOrUpdateInPortImagePersona {
    ResponseEntity<?> saveOrUpdateImagen(MultipartFile img, Long ci) throws IOException;
}
