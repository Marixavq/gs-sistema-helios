package com.fiap.sistemahelios.dto.request;

public record SensorRequestDTO (

        Long idModulo,
        String nomeSensor,
        String tipoSensor,
        String statusSensor,
        String unidadeMedida,
        Double limiteMinimo,
        Double limiteMaximo,
        Integer intervaloLeituraSegundos
) {
}
