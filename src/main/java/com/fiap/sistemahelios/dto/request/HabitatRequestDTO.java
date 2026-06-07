package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record HabitatRequestDTO(

        @NotBlank(message = "Nome do habitat é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        @Schema(
                description = "Nome do habitat",
                example = "Artemis Alpha",
                minLength = 3,
                maxLength = 100
        )
        String nome,

        @NotBlank(message = "Localização é obrigatória")
        @Size(max = 100, message = "A localização deve ter no máximo 100 caracteres")
        @Schema(
                description = "Localização do habitat",
                example = "Lua - Setor Norte",
                maxLength = 100
        )
        String localizacao,


        @NotBlank(message = "Tipo de habitat é obrigatório")
        @Size(max = 50, message = "O tipo de habitat deve ter  no máximo 50 caracteres")
        @Schema(
                description = "Tipo do habitat",
                example = "Pesquisa",
                maxLength = 50
        )
        String tipoHabitat,

        @NotNull(message = "Capacidade total é obrigatória")
        @Positive(message = "A capacidade total deve ser maior que zero")
        @Schema(
                description = "Capacidade total do habitat",
                example = "80"
        )
        Integer capacidadeTotal,

        @NotBlank(message = "Status operacional é obrigatório")
        @Size(max = 30, message = "O status operacional deve ter no máximo 30 caracteres")
        @Schema(
                description = "Status operacional do habitat",
                example = "Operacional",
                maxLength = 30
        )
        String statusOperacional

) {
}



