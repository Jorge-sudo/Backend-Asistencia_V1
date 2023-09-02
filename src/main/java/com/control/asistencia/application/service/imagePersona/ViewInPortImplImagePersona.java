package com.control.asistencia.application.service.imagePersona;

import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.config.img.StoragePaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.Base64;


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
    public String viewByNameImagePersona(String nameImg) {

        String base64;
        // Se obtiene la ruta completa del archivo a cargar
        Path rutaArchivo = this.storagePaths.imgDirectory().resolve(nameImg).toAbsolutePath();

        try {
            // Se crea un recurso de Spring Resource a partir de la ruta del archivo
            Resource recurso = new UrlResource(rutaArchivo.toUri());
            // Si el archivo no existe o no se puede leer, se carga una imagen predeterminada
            if (!recurso.exists() && !recurso.isReadable()) {
                rutaArchivo = this.storagePaths.imgDirectory()
                        .resolve("no-usuario.png").toAbsolutePath();
                recurso = new UrlResource(rutaArchivo.toUri());
                log.error("Este usuario no tiene imagen definido: " + nameImg);
            }
            // Se lee la imagen del recurso y se convierte en una cadena de caracteres en formato base64
            InputStream inputStream = recurso.getInputStream();
            byte[] bytes = IOUtils.toByteArray(inputStream);
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return base64;
    }

    @Override
    public boolean thisImagePersonaExists(String nameImg) {
        // Se obtiene la ruta completa del archivo a cargar
        Path rutaArchivo = this.storagePaths.imgDirectory().resolve(nameImg).toAbsolutePath();


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
