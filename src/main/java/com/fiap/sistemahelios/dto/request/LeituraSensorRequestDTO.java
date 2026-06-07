package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record LeituraSensorRequestDTO (

        @NotNull(message = "O sensor é obrigatório")
        @Schema(
                description = "Sensor responsável pela leitura",
                example = "1"
        )
        Long idSensor,

        @NotNull(message = "O valor da leitura é obrigatório")
        @Schema(
                description = "Valor registrado pelo sensor",
                example = "23.5"
        )
        Double valorLeitura,

        @NotNull(message = "Data e hora da leitura são obrigatórias")
        @Schema(
                description = "Data e hora em que a leitura foi realizada",
                example = "2026-06-07T14:30:00"
        )
        LocalDateTime dataHoraLeitura,

        @NotBlank(message = "O status da leitura é obrigatório")
        @Size(max = 20, message = "O status da leitura deve ter no máximo 20 caracteres")
        @Schema(
                description = "Status da leitura realizada pelo sensor",
                example = "NORMAL"
        )
        String statusLeitura
){
}
