package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AcaoAutomaticaRequestDTO (

        @NotNull(message = "O alerta é obrigatório")
        @Schema(
                description = "Alerta que originou a ação automática",
                example = "1"
        )
        Long idAlerta,

        @NotBlank(message = "A descrição da ação é obrigatória")
        @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
        @Schema(
                description = "Descrição da ação automática executada",
                example = "Redução automática da temperatura do módulo",
                maxLength = 255
        )
        String descricao,

        @NotNull(message = "A data e hora de execução são obrigatórias")
        @Schema(
                description = "Data e hora em que a ação automática foi executada",
                example = "2026-06-07T14:35:00"
        )
        LocalDateTime dataHoraExecucao,

        @NotBlank(message = "O status da ação é obrigatório")
        @Size(max = 30, message = "O status da ação deve ter no máximo 30 caracteres")
        @Schema(
                description = "Status atual da ação automática",
                example = "EXECUTADA",
                maxLength = 30
        )
        String statusAcao
) {}