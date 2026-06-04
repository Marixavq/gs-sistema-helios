package com.fiap.sistemahelios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;

public record ModuloHabitacionalRequestDTO (

    @NotNull(message = "Habitat é obrigatório")
    @Schema(
            description = "ID do habitat é obrigatório",
            example = "1"
    )
    Long idHabitat,

    @NotBlank(message = "Nome do módulo é obrigatório")
    @Size(min = 3, max = 100, message = "O nome do módulo deve ter entre 3 e 100 caracteres")
    @Column(name = "nome_modulo", nullable = false, length = 100)
    @Schema(
            description = "Nome do módulo",
            example = "Modulo Aurora"
    )
    String nomeModulo,

    @NotBlank(message = "Tipo do módulo é obrigatório")
    @Size(min = 3, max = 50, message = "O tipo do módulo deve ter entre 3 e 50 caracteres")
    @Column(name = "tipo_modulo", nullable = false, length = 50)
    @Schema(
            description = "Tipo do módulo",
            example = "Residencial"
    )
    String tipoModulo,

    @NotNull(message = "Capacidade de ocupantes é obrigatória")
    @Positive(message = "A capacidade deve ser maior que zero")
    @Column(name = "capacidade_ocupantes", nullable = false)
    @Schema(
            description = "Capacidade de ocupantes",
            example = "8"
    )
    Integer capacidadeOcupantes,


    Integer capacidadeAtual,

    @NotBlank(message = "Status do módulo é obrigatório")
    @Size(max = 20, message = "O status do módulo deve ter no máximo 20 caracteres")
    @Column(name = "status_modulo", nullable = false, length = 20)
    @Schema(
            description = "Status do módulo",
            example = "Ativo"
    )
    String statusModulo,

    @NotBlank(message = "Nível de risco é obrigatório")
    @Size(max = 20, message = "O nível de risco deve ter no máximo 20 caracteres")
    @Column(name = "nivel_risco", nullable = false, length = 20)
    @Schema(
            description = "Nível de risco",
            example = "Baixo"
    )
    String nivelRisco,

    @NotNull(message = "Consumo de energia é obrigatório")
    @PositiveOrZero(message = "O consumo de energia não pode ser negativo")
    @Column(name = "consumo_energia", nullable = false)
    @Schema(
            description = "Consumo de energia ",
            example = "1250.5"
    )
    Double consumoEnergia,

    @NotNull(message = "Consumo de água é obrigatório")
    @PositiveOrZero(message = "O consumo de água não pode ser negativo")
    @Column(name = "consumo_agua", nullable = false)
    @Schema(
            description = "Consumo de água",
            example = "780.0"
    )
    Double consumoAgua

) {
}
