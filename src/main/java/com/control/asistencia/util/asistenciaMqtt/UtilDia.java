package com.control.asistencia.util.asistenciaMqtt;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

@Component
public class UtilDia {
    public static String getDiaSemana(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        return switch (diaSemana) {
            case 1 -> "Domingo";
            case 2 -> "Lunes";
            case 3 -> "Martes";
            case 4 -> "Miércoles";
            case 5 -> "Jueves";
            case 6 -> "Viernes";
            case 7 -> "Sábado";
            default -> "";
        };
    }

}
