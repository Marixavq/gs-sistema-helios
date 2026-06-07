package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AlertaRequestDTO(

        @NotNull(message = "O módulo é obrigatório")
        @Schema(
                description = "Módulo habitacional associado ao alerta",
                example = "1"
        )
         Long idModulo,

        @NotNull(message = "O sensor é obrigatório")
        @Schema(
                description = "Sensor que gerou o alerta",
                example = "1"
        )
         Long idSensor,

        @NotBlank(message = "Tipo de alerta é obrigatório")
        @Size(max = 50, message = "O tipo de alerta deve ter no máximo 50 caracteres")
        @Schema(
                description = "Tipo do alerta gerado pelo sistema",
                example = "TEMPERATURA_ALTA",
                maxLength = 50
        )
         String tipoAlerta,

        @NotBlank(message = "Mensagem é obrigatória")
        @Size(max = 255, message = "A mensagem deve ter no máximo 255 caracteres")
        @Schema(
                description = "Mensagem descritiva do alerta",
                example = "Temperatura acima do limite permitido",
                maxLength = 255
        )
         String mensagem,

        @NotBlank(message = "Nível de criticidade é obrigatório")
        @Size(max = 30, message = "O nível de criticidade deve ter no máximo 30 caracteres")
        @Schema(
                description = "Nível de criticidade do alerta",
                example = "ALTO",
                maxLength = 30
        )
         String nivelCriticidade,

        @NotNull(message = "Data e hora do alerta é obrigatória")
        @Schema(
                description = "Data e hora em que o alerta foi gerado",
                example = "2026-06-07T14:30:00"
        )
         LocalDateTime dataHoraAlerta,

        @NotBlank(message = "Status do alerta é obrigatório")
        @Size(max = 30, message = "O status do alerta deve ter no máximo 30 caracteres")
        @Schema(
                description = "Status atual do alerta",
                example = "ABERTO",
                maxLength = 30
        )
         String statusAlerta

){
}
