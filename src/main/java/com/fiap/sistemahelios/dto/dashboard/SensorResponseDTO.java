package com.fiap.sistemahelios.dto.dashboard;

import com.fiap.sistemahelios.model.Sensor;

public record SensorResponseDTO(

        Long id,
        String nomeSensor,
        String tipoSensor,
        Double limiteMinimo,
        Double limiteMaximo,
        String unidadeMedida,
        Integer intervaloLeituraSegundos,
        String statusSensor

) {

    public static SensorResponseDTO fromEntity(Sensor sensor) {
        return new SensorResponseDTO(
                sensor.getId(),
                sensor.getNomeSensor(),
                sensor.getTipoSensor(),
                sensor.getLimiteMinimo(),
                sensor.getLimiteMaximo(),
                sensor.getUnidadeMedida(),
                sensor.getIntervaloLeituraSegundos(),
                sensor.getStatusSensor()
        );
    }
}

