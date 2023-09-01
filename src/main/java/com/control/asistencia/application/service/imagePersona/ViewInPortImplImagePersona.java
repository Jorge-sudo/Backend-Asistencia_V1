package com.control.asistencia.application.service.imagePersona;

import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.config.img.StoragePaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.nio.file.Path;


@UseCase
public class ViewInPortImplImagePersona implements IViewInPortImagePersona {
    // Se crea una instancia del Logger de SLF4J para registrar información y errores
    private final Logger log = LoggerFactory.getLogger(ViewInPortImplImagePersona.class);
    private final StoragePaths storagePaths;
    public ViewInPortImplImagePersona(StoragePaths storagePaths) {
        this.storagePaths = storagePaths;
        this.storagePaths.createDirectoryIsNoTExists();
    }
    @Override
    public boolean thisImagePersonaExists(String nameImg) {
        // Se obtiene la ruta completa del archivo a cargar
        Path rutaArchivo = this.storagePaths.imgDirectory().resolve(nameImg).toAbsolutePath();

        // Se registra la información de la ruta del archivo a cargar
        log.info(rutaArchivo.toString());

        // Se crea un recurso de Spring Resource a partir de la ruta del archivo
        Resource recurso = null;
        try {
            recurso = new UrlResource(rutaArchivo.toUri());
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }

        assert recurso != null;

        return recurso.exists() && recurso.isReadable();
    }
}
