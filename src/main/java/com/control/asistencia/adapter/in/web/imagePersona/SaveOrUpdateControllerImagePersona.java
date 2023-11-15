package com.control.asistencia.adapter.in.web.imagePersona;

import com.control.asistencia.application.port.in.imagePersona.ISaveOrUpdateInPortImagePersona;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerImagePersona {
    private final ISaveOrUpdateInPortImagePersona iSaveOrUpdateInPortImagePersona;
    public SaveOrUpdateControllerImagePersona(
            ISaveOrUpdateInPortImagePersona iSaveOrUpdateInPortImagePersona) {
        this.iSaveOrUpdateInPortImagePersona = iSaveOrUpdateInPortImagePersona;
    }

    @PostMapping("/image_persona/upload")
    ResponseEntity<?> saveOrUpdateImagePersona(
            @RequestParam("file") MultipartFile file,
            @RequestParam("ci") Long ci) throws IOException {

        return this.iSaveOrUpdateInPortImagePersona.saveOrUpdateImagen(file, ci);
    }
}
