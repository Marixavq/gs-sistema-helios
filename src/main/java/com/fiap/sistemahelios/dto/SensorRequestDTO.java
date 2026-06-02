package com.fiap.sistemahelios.dto;


import java.time.LocalDate;

public record SensorRequestDTO (

        Long idModulo,
        String nomeSensor,
        String tipoSensor,
        String statusSensor,
        String unidadeMedida,
        Double limiteMinimo,
        Double limiteMaximo,
        LocalDate dataInstalacao

) {
}
