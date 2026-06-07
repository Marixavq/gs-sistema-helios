package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ReservaRequestDTO(

        @NotNull(message = "O ocupante é obrigatório")
        @Schema(
                description = "Ocupante da reserva",
                example = "1"
        )
        Long idOcupante,

        @NotNull(message = "O módulo é obrigatório")
        @Schema(
                description = "ModuloHabitacional da reserva",
                example = "1"
        )
        Long idModulo,

        @NotNull(message = "Data de início da reserva é obrigatória")
        @Schema(
                description = "Data de início da reserva do usuário",
                example = "2026-05-04"
        )
        LocalDate dataInicio,

        @NotNull(message = "Data de fim da reserva é obrigatória")
        @Schema(
                description = "Data de fim da reserva do usuário",
                example = "2026-05-14"
        )
        LocalDate dataFim,

        @NotBlank(message = "Status da reserva é obrigatório")
        @Size(max = 30, message = "O status deve ter no máximo 30 caracteres")
        @Schema(
                description = "Indica se a reserva ainda está ativa sistema",
                example = "Cancelada",
                maxLength = 30
        )
        String statusReserva

) {
}
