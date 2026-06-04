package com.fiap.sistemahelios.dto;

public record RegraAlertaRequestDTO(

        String tipoSensor,
        Double valorMinimo,
        Double valorMaximo,
        String nivelCriticidade,
        String mensagemPadrao,
        Boolean ativo

) {
}
