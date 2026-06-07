package com.fiap.sistemahelios.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SensorRequestDTO (

        @NotNull(message = "O módulo é obrigatório")
        @Schema(
                description = "Módulo habitacional ao qual o sensor está vinculado",
                example = "1"
        )
        Long idModulo,

        @NotBlank(message = "Nome do sensor é obrigatório")
        @Size(max = 100, message = "O nome do sensor deve ter no máximo 100 caracteres")
        @Schema(
                description = "Nome do sensor",
                example = "Sensor de Temperatura Interna",
                maxLength = 100
        )
        String nomeSensor,

        @NotBlank(message = "Tipo do sensor é obrigatório")
        @Size(max = 50, message = "O tipo do sensor deve ter no máximo 50 caracteres")
        @Schema(
                description = "Tipo do sensor (temperatura, umidade, pressão etc.)",
                example = "Temperatura",
                maxLength = 50
        )
        String tipoSensor,

        @NotBlank(message = "Status do sensor é obrigatório")
        @Size(max = 30, message = "O status do sensor deve ter no máximo 30 caracteres")
        @Schema(
                description = "Status atual do sensor",
                example = "ATIVO",
                maxLength = 30
        )
        String statusSensor,

        @NotBlank(message = "Unidade de medida é obrigatória")
        @Size(max = 20, message = "A unidade de medida deve ter no máximo 20 caracteres")
        @Schema(
                description = "Unidade de medida do sensor",
                example = "°C",
                maxLength = 20
        )
        String unidadeMedida,

        @NotNull(message = "Limite mínimo é obrigatório")
        @Schema(
                description = "Valor mínimo aceitável do sensor",
                example = "10.5"
        )
        Double limiteMinimo,

        @NotNull(message = "Limite máximo é obrigatório")
        @Schema(
                description = "Valor máximo aceitável do sensor",
                example = "35.0"
        )
        Double limiteMaximo,

        @NotNull(message = "Intervalo de leitura é obrigatório")
        @Positive(message = "O intervalo deve ser maior que zero")
        @Schema(
                description = "Intervalo de leitura do sensor em segundos",
                example = "60"
        )
        Integer intervaloLeituraSegundos
) {
}
