package com.fiap.sistemahelios.dto;

import com.fiap.sistemahelios.model.LeituraSensor;

import java.time.LocalDateTime;

public record LeituraSensorResponseDTO(

        Long id,
        String nomeSensor,
        Double valorLeitura,
        LocalDateTime dataHoraLeitura,
        String statusLeitura

) {

    public static LeituraSensorResponseDTO fromEntity (LeituraSensor leituraSensor){
        return new LeituraSensorResponseDTO(
                leituraSensor.getId(),
                leituraSensor.getSensor().getNomeSensor(),
                leituraSensor.getValorLeitura(),
                leituraSensor.getDataHoraLeitura(),
                leituraSensor.getStatusLeitura()

        );
    }
}