package com.fiap.sistemahelios.dto.dashboard;

import com.fiap.sistemahelios.model.LeituraSensor;

public record LeituraSensorResponseDTO(

        Long id,
        String nomeSensor,
        String tipoSensor,
        Double valorLeitura,
        String unidadeMedida,
        String statusLeitura

) {

    public static LeituraSensorResponseDTO fromEntity (LeituraSensor leituraSensor){
        return new LeituraSensorResponseDTO(
                leituraSensor.getId(),
                leituraSensor.getSensor().getNomeSensor(),
                leituraSensor.getSensor().getTipoSensor(),
                leituraSensor.getValorLeitura(),
                leituraSensor.getSensor().getUnidadeMedida(),
                leituraSensor.getStatusLeitura()

        );
    }
}