package com.control.asistencia.application.service.imagePersona;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.adapter.out.persistence.entity.PersonaEntity;
import com.control.asistencia.application.port.in.imagePersona.IDeleteInPortImagePersona;
import com.control.asistencia.application.port.in.imagePersona.ISaveOrUpdateInPortImagePersona;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.application.port.out.persona.ISaveOrUpdateOutPortPersona;
import com.control.asistencia.application.port.out.persona.IViewOutPortPersona;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.config.img.StoragePaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplImagePersona  implements ISaveOrUpdateInPortImagePersona {
    private final Logger log = LoggerFactory.getLogger(SaveOrUpdateInPortImplImagePersona.class);
    private final StoragePaths storagePaths;
    private final IViewInPortImagePersona iViewInPortImagePersona;
    private final IDeleteInPortImagePersona iDeleteInPortImagePersona;
    private final IViewOutPortPersona iViewOutPortPersona;
    private final ISaveOrUpdateOutPortPersona iSaveOrUpdateOutPortPersona;
    public SaveOrUpdateInPortImplImagePersona(
            StoragePaths storagePaths ,
            IViewInPortImagePersona iViewInPortImagePersona ,
            IDeleteInPortImagePersona iDeleteInPortImagePersona ,
            IViewOutPortPersona iViewOutPortPersona ,
            ISaveOrUpdateOutPortPersona iSaveOrUpdateOutPortPersona) {

        this.storagePaths = storagePaths;
        this.iViewInPortImagePersona = iViewInPortImagePersona;
        this.iDeleteInPortImagePersona = iDeleteInPortImagePersona;
        this.iViewOutPortPersona = iViewOutPortPersona;
        this.iSaveOrUpdateOutPortPersona = iSaveOrUpdateOutPortPersona;
        this.storagePaths.createDirectoryIsNoTExists();
    }
    @Override
    public ResponseEntity<?> saveOrUpdateImagen(MultipartFile img, Long ci) throws IOException {
        boolean update = false;
        boolean save = false;

        Optional<PersonaEntity> personaEntity = this.iViewOutPortPersona.viewById(ci);

        if(personaEntity.isEmpty()){
            throw new DataNotFoundExceptionMessage("No se encontró la persona con el ci :" + ci);
        }

        if(img.isEmpty()){
            throw new DataNotFoundExceptionMessage("El archivo no puede estar vacío");
        }

        // Se obtiene la extensión del archivo
        String nameImg = getString(img, personaEntity);

        // Se verifica si existe una imagen con el mismo nombre
        if(this.iViewInPortImagePersona.thisImagePersonaExists(nameImg)){
            // Se elimina la imagen
            this.iDeleteInPortImagePersona.deleteImagePersona(nameImg);
            update = true;
        }else{
            save = true;
        }

        // Se obtiene la ruta completa donde se guardará el archivo
        Path pathImg = this.storagePaths.imgDirectory().resolve(nameImg).toAbsolutePath();

        // Se copia el archivo a la ruta especificada
        try {
            Files.copy(img.getInputStream(), pathImg);
            personaEntity.get().setFotografia(nameImg);
            this.iSaveOrUpdateOutPortPersona.saveOrUpdatePersona(personaEntity.get());
            return ResponseBuilderApiRest.saveOrUpdateImage(save, update);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return ResponseBuilderApiRest.saveOrUpdateImage(save, update);

    }

    private static String getString(MultipartFile img, Optional<PersonaEntity> personaEntity) {
        String extension = Objects.requireNonNull(img.getOriginalFilename())
                .substring(
                        img.getOriginalFilename().lastIndexOf(".") + 1
                );

        assert personaEntity.isPresent();

        return (personaEntity.get().getNombre()
                + "_" + personaEntity.get().getApellido()
                + "_" + personaEntity.get().getCi() + "." + extension)
                .replaceAll("\\s+", "");// elimina todos los espacios en blanco
    }
}
