package com.fiap.sistemahelios.dto;

import com.fiap.sistemahelios.model.Sensor;

import java.time.LocalDate;

public record SensorResponseDTO(

        Long id,
        String nomeModulo,
        String nomeSensor,
        String tipoSensor,
        String statusSensor,
        String unidadeMedida,
        Double limiteMinimo,
        Double limiteMaximo,
        Integer intervaloLeituraSegundos,
        LocalDate dataInstalacao

) {

    public static SensorResponseDTO fromEntity(Sensor sensor) {
        return new SensorResponseDTO(
                sensor.getId(),
                sensor.getModulo().getNomeModulo(),
                sensor.getNomeSensor(),
                sensor.getTipoSensor(),
                sensor.getStatusSensor(),
                sensor.getUnidadeMedida(),
                sensor.getLimiteMinimo(),
                sensor.getLimiteMaximo(),
                sensor.getIntervaloLeituraSegundos(),
                sensor.getDataInstalacao()
        );
    }
}

