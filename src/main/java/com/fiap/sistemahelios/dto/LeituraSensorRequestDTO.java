package com.fiap.sistemahelios.dto;

import java.time.LocalDateTime;

public record LeituraSensorRequestDTO (

        Long idSensor,
        Double valorLeitura,
        LocalDateTime dataHoraLeitura,
        String statusLeitura
){
}
