package com.control.asistencia.domain.mqttAsistencia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MqttMessageResponseAsistencia {
    private String estado;
    private int idAsistencia;
}
