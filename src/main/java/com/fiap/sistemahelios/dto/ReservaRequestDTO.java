package com.fiap.sistemahelios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ReservaRequestDTO(

        @Schema(
                description = "ID do usuário responsável pela reserva é obrigatório",
                example = "1"
        )
        @NotNull(message = "ID do responsável pela reserva é obrigatório")
        Long idUsuario,

        @Schema(
                description = "ID do Modulo Habitacional da reserva é obrigatório",
                example = "1"
        )
        @NotNull(message = "ID do Modulo Habitacional da reserva é obrigatório")
        Long idModulo,

        @NotBlank(message = "Data de fim da reserva é obrigatória")
        @Schema(
                description = "Data de fim da reserva do usuário",
                example = "2026-05-14"
        )
        LocalDate dataInicio,

        @NotBlank(message = "Data de fim da reserva é obrigatória")
        @Schema(
                description = "Data de fim da reserva do usuário",
                example = "2026-05-14"
        )
        LocalDate dataFim,

        @NotBlank(message = "Status da reserva é obrigatório")
        @Schema(
                description = "Indica se a reserva ainda está ativa sistema",
                example = "Cancelada"
        )
        String statusReserva

) {
}
