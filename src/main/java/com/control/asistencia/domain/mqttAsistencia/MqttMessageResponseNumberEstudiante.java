package com.control.asistencia.domain.mqttAsistencia;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MqttMessageResponseNumberEstudiante {
    private int idAsistencia;
    private int cantEstudiantes;

    public MqttMessageResponseNumberEstudiante() {
        // Constructor predeterminado
    }

    @JsonCreator
    public MqttMessageResponseNumberEstudiante(
            @JsonProperty("idAsistencia") int idAsistencia,
            @JsonProperty("cantEstudiantes") int cantEstudiantes) {
        // Constructor con argumentos
        this.idAsistencia = idAsistencia;
        this.cantEstudiantes = cantEstudiantes;
    }
}
