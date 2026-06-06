package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record HabitatRequestDTO(

        @NotBlank(message = "Nome do habitat é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        @Column(nullable = false, length = 100)
        @Schema(
                description = "Nome do habitat",
                example = "Tundralândia",
                minLength = 3,
                maxLength = 100
        )
        String nome,

        @NotBlank(message = "Localização é obrigatória")
        @Size(min = 3, max = 50, message = "A localização deve ter entre 3 e 50 caracteres")
        @Column(nullable = false, length = 100)
        @Schema(
                description = "Localização do habitat",
                example = "Marte",
                minLength = 3,
                maxLength = 50
        )
        String localizacao,

        @NotBlank(message = "Tipo de habitat é obrigatório")
        @Size(min = 3, max = 50, message = "O tipo de habitat deve ter entre 3 e 50 caracteres")
        @Column(name = "tipo_habitat", nullable = false, length = 50)
        @Schema(
                description = "Nome do habitat",
                example = "Tundralândia",
                minLength = 3,
                maxLength = 50
        )
        String tipoHabitat,

        @NotNull(message = "Capacidade total é obrigatória")
        @Positive(message = "A capacidade total deve ser maior que zero")
        @Column(name = "capacidade_total", nullable = false)
        @Schema(
                description = "Capacidade total do habitat",
                example = "50"
        )
        Integer capacidadeTotal,

        @NotBlank(message = "Status operacional é obrigatório")
        @Size(max = 20, message = "O status operacional deve ter no máximo 20 caracteres")
        @Column(name = "status_operacional", nullable = false, length = 20)
        @Schema(
                description = "Status operacional do habitat",
                example = "Ativo"
        )
        String statusOperacional

) {
}



