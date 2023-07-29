package com.control.asistencia.adapter.in.web.utilController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Boolean view;
    private Boolean save;
    private Boolean update;
    private Boolean delete;
    private String message;
    private Optional<?> data;
}
