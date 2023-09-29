package com.control.asistencia.util.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResponseBuilderApiRest {

    public static ResponseEntity<?> view(Optional<?> data) {
        return buildResponse(
                "Tus datos fueron mostrados exitosamente.",
                HttpStatus.OK,
                true,
                false,
                false,
                false,
                data);
    }

    public static ResponseEntity<?> viewPage(Page<?> data) {
        return buildResponse(
                "Tus datos fueron mostrados exitosamente.",
                HttpStatus.OK,
                true,
                false,
                false,
                false,
                Optional.of(data));
    }

    public static ResponseEntity<?> save(Optional<?> data) {
        return buildResponse(
                "Tus datos se guardaron con éxito.",
                HttpStatus.CREATED,
                false,
                true,
                false,
                false,
                data);
    }

    public static ResponseEntity<?> saveOrUpdateImage(boolean save, boolean update){
        return buildResponse(
                "Su operación fue exitosa.",
                HttpStatus.CREATED,
                false,
                save,
                update,
                false,
                Optional.empty());
    }


    public static ResponseEntity<?> update(Optional<?> data) {
        return buildResponse(
                "Tus datos se actualizaron con éxito.",
                HttpStatus.OK,
                false,
                false,
                true,
                false,
                data);
    }

    public static ResponseEntity<?> updateActivo(boolean result) {
        return buildResponse(
                "Tus datos se actualizaron con éxito.",
                HttpStatus.OK,
                false,
                false,
                result,
                false,
                Optional.empty());
    }
    public static ResponseEntity<?> delete(boolean result) {
        return buildResponse(
                result ? "Tus datos fueron eliminados con éxito.": "Tus datos no fueron eliminados, revisa el id enviado.",
                HttpStatus.OK,
                false,
                false,
                false,
                result,
                Optional.empty());
    }

    private static ResponseEntity<?> buildResponse(
            String message,
            HttpStatus status,
            boolean view,
            boolean save,
            boolean update,
            boolean delete,
            Optional<?> data) {

        Response response = new Response();
        response.setMessage(message);
        response.setView(view);
        response.setSave(save);
        response.setUpdate(update);
        response.setDelete(delete);
        response.setData(data);

        return ResponseEntity.status(status).body(response);
    }
}
