package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OcupanteRequestDTO(

        @NotBlank(message = "Nome do ocupante é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        @Schema(
                description = "Nome do ocupante",
                example = "João Silva",
                maxLength = 100
        )
        String nome,

        @NotBlank(message = "Função do ocupante é obrigatória")
        @Size(max = 50, message = "A função deve ter no máximo 50 caracteres")
        @Schema(
                description = "Função desempenhada pelo ocupante",
                example = "Engenheiro",
                maxLength = 50
        )
        String funcao,

        @NotBlank(message = "Status do ocupante é obrigatório")
        @Size(max = 30, message = "O status deve ter no máximo 30 caracteres")
        @Schema(
                description = "Status atual do ocupante",
                example = "ATIVO",
                maxLength = 30
        )
        String statusOcupante


) {
}
