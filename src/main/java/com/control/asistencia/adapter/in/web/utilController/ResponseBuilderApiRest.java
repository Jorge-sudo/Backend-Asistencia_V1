package com.control.asistencia.adapter.in.web.utilController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResponseBuilderApiRest {
    public static ResponseEntity<?> success(Optional<?> data) {
        return buildResponse(
                "Operation success.",
                HttpStatus.OK,
                false,
                false,
                false,
                false,
                data
        );
    }

    public static ResponseEntity<?> view(Optional<?> data) {
        return buildResponse(
                "Your data was show successfully.",
                HttpStatus.OK,
                true,
                false,
                false,
                false,
                data);
    }

    public static ResponseEntity<?> save(Optional<?> data) {
        return buildResponse(
                "Your data was saved successfully.",
                HttpStatus.CREATED,
                false,
                true,
                false,
                false,
                data);
    }

    public static ResponseEntity<?> update(Optional<?> data) {
        return buildResponse(
                "Your data was updated successfully.",
                HttpStatus.OK,
                false,
                false,
                true,
                false,
                data);
    }
    public static ResponseEntity<?> delete(boolean result) {
        return buildResponse(
                result ? "Your data was deleted successfully.": "Your data was not deleted, check the id sent.",
                HttpStatus.OK,
                false,
                false,
                false,
                result,
                Optional.empty());
    }

    public static ResponseEntity<?> error(HttpStatus status) {
        return buildResponse(
                "An error occurred, check your data.",
                status,
                false,
                false,
                false,
                false,
                Optional.empty());
    }

    public static ResponseEntity<?> errorWithData(Optional<?> data, HttpStatus status) {
        return buildResponse(
                "Data not found by id to save the data or some attribute is missing check your data.",
                status,
                false,
                false,
                false,
                false,
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
