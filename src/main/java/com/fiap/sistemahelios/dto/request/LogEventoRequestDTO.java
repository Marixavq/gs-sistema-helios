package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record LogEventoRequestDTO(

        @NotBlank(message = "O tipo do evento é obrigatório")
        @Size(max = 50, message = "O tipo do evento deve ter no máximo 50 caracteres")
        @Schema(
                description = "Tipo do evento registrado",
                example = "ALERTA",
                maxLength = 50
        )
         String tipoEvento,

        @NotBlank(message = "A descrição do evento é obrigatória")
        @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
        @Schema(
                description = "Descrição detalhada do evento",
                example = "Sensor de temperatura registrou valor acima do limite",
                maxLength = 255
        )
         String descricao,

        @NotNull(message = "A data e hora do evento são obrigatórias")
        @Schema(
                description = "Data e hora em que o evento ocorreu",
                example = "2026-06-07T14:45:00"
        )
         LocalDateTime dataHoraEvento,

        @NotBlank(message = "A origem do evento é obrigatória")
        @Size(max = 100, message = "A origem do evento deve ter no máximo 100 caracteres")
        @Schema(
                description = "Origem responsável pela geração do evento",
                example = "Sensor de Temperatura do Módulo Aurora",
                maxLength = 100
        )
         String origemEvento,

        @NotBlank(message = "O nível do evento é obrigatório")
        @Size(max = 30, message = "O nível do evento deve ter no máximo 20 caracteres")
        @Schema(
                description = "Nível de severidade do evento",
                example = "ALTO",
                maxLength = 30
        )
         String nivelEvento
) {
}
