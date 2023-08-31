package com.control.asistencia.application.service.imagePersona;

import com.control.asistencia.application.port.in.imagePersona.IDeleteInPortImagePersona;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.config.img.StoragePaths;

import java.io.File;
import java.nio.file.Path;

@UseCase
public class DeleteInPortImplImagePersona  implements IDeleteInPortImagePersona {
    private final StoragePaths storagePaths;
    public DeleteInPortImplImagePersona(StoragePaths storagePaths) {
        this.storagePaths = storagePaths;
    }
    @Override
    public boolean deleteImagePersona(String nameImg) {
        // Si se proporciona un nombre de archivo válido
        if(nameImg != null && !nameImg.isEmpty()) {
            // Se obtiene la ruta completa del archivo a eliminar
            Path pathImg = this.storagePaths.imgDirectory().resolve(nameImg);
            File fileImg = pathImg.toFile();

            // Si el archivo existe y se puede leer, se elimina
            if(fileImg.exists() && fileImg.canRead()) {
                return fileImg.delete();
            }
        }
        // Si no se puede eliminar el archivo, se devuelve false
        return false;
    }
}
