package com.fiap.sistemahelios.dto.request;

public record RegraAlertaRequestDTO(

        String tipoSensor,
        Double valorMinimo,
        Double valorMaximo,
        String nivelCriticidade,
        String mensagemPadrao,
        Boolean ativo

) {
}
