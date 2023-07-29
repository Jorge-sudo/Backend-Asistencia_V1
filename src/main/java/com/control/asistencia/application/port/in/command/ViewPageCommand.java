package com.control.asistencia.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewPageCommand {
    private int page;
    private int size;
    private String sortBy;
}
