package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public record RegraAlertaRequestDTO(


        @NotBlank(message = "Tipo do sensor é obrigatório")
        @Size(max = 50, message = "O tipo do sensor deve ter no máximo 50 caracteres")
        @Schema(
                description = "Tipo do sensor associado à regra",
                example = "Temperatura",
                maxLength = 50
        )
        String tipoSensor,

        @NotNull(message = "Valor mínimo é obrigatório")
        @Schema(
                description = "Valor mínimo permitido para disparo da regra",
                example = "10.0"
        )
        Double valorMinimo,

        @NotNull(message = "Valor máximo é obrigatório")
        @Schema(
                description = "Valor máximo permitido para disparo da regra",
                example = "35.0"
        )
        Double valorMaximo,


        @NotBlank(message = "Nível de criticidade é obrigatório")
        @Size(max = 30, message = "O nível de criticidade deve ter no máximo 30 caracteres")
        @Schema(
                description = "Nível de criticidade da regra",
                example = "ALTO",
                maxLength = 30
        )
        String nivelCriticidade,

        @NotNull(message = "O peso de risco é obrigatório")
        @Min(value = 1, message = "O peso de risco deve ser no mínimo 1")
        @Max(value = 10, message = "O peso de risco deve ser no máximo 10")
        @Schema(
                description = "Peso utilizado para cálculo e priorização do risco",
                example = "5",
                minimum = "1",
                maximum = "10"
        )
        Integer pesoRisco,

        @NotBlank(message = "Mensagem padrão é obrigatória")
        @Size(max = 255, message = "A mensagem padrão deve ter no máximo 255 caracteres")
        @Schema(
                description = "Mensagem padrão exibida quando a regra é acionada",
                example = "Sensor fora do intervalo permitido",
                maxLength = 255
        )
        String mensagemPadrao,

        @NotNull(message = "Campo ativo é obrigatório")
        @Column(nullable = false)
        @Schema(
                description = "Indica se a regra está ativa no sistema",
                example = "true"
        )
        Boolean ativo

) {
}
