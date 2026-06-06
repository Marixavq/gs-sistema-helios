package com.fiap.sistemahelios.dto.request;

import java.time.LocalDateTime;

public record LeituraSensorRequestDTO (

        Long idSensor,
        Double valorLeitura,
        LocalDateTime dataHoraLeitura,
        String statusLeitura
){
}
