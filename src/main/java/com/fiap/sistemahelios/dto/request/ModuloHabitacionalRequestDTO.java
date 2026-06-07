package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public record ModuloHabitacionalRequestDTO (

        @NotNull(message = "Habitat é obrigatório")
        @Schema(
                description = "Habitat associado a ModuloHabitacional",
                example = "1"
        )
        Long idHabitat,

        @NotBlank(message = "Nome do módulo é obrigatório")
        @Size(max = 100, message = "O nome do módulo deve ter no máximo 100 caracteres")
        @Column(name = "nome_modulo", nullable = false, length = 100)
        @Schema(
                description = "Nome do módulo habitacional",
                example = "Módulo Aurora",
                maxLength = 100
        )
        String nomeModulo,


        @NotBlank(message = "Tipo do módulo é obrigatório")
        @Size(max = 50, message = "O tipo do módulo deve ter no máximo 50 caracteres")
        @Schema(
                description = "Tipo do módulo habitacional",
                example = "Residencial",
                maxLength = 50
        )
        String tipoModulo,

        @NotNull(message = "Capacidade de ocupantes é obrigatória")
        @Positive(message = "A capacidade deve ser maior que zero")
        @Schema(
                description = "Capacidade máxima de ocupantes do módulo",
                example = "8"
        )
        Integer capacidadeOcupantes,

        @NotNull(message = "Capacidade de ocupantes é obrigatória")
        @PositiveOrZero(message = "A capacidade deve ser maior ou igual a zero")
        @Schema(
                description = "Quantidade atual de ocupantes no módulo",
                example = "5"
        )
        Integer ocupacaoAtual,

        @NotBlank(message = "Status do módulo é obrigatório")
        @Size(max = 30, message = "O status do módulo deve ter no máximo 30 caracteres")
        @Schema(
                description = "Status operacional do módulo",
                example = "ATIVO",
                maxLength = 30
        )
        String statusModulo,

        @NotBlank(message = "Nível de risco é obrigatório")
        @Size(max = 20, message = "O nível de risco deve ter no máximo 20 caracteres")
        @Schema(
                description = "Classificação do nível de risco do módulo",
                example = "BAIXO",
                maxLength = 20
        )
        String nivelRisco,

        @NotNull(message = "Indice de risco é obrigatório")
        @PositiveOrZero(message = "O indice de risco  deve ser maior ou igual a zero")
        @Schema(
                description = "Índice numérico de risco do módulo",
                example = "12.75"
        )
        String indiceRisco

) {
}
