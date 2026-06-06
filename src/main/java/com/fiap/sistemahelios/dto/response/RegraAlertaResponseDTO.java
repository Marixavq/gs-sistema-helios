package com.fiap.sistemahelios.dto.response;

import com.fiap.sistemahelios.model.RegraAlerta;

public record RegraAlertaResponseDTO (

        Long id,
        String tipoSensor,
        Double valorMinimo,
        Double valorMaximo,
        String nivelCriticidade,
        String mensagemPadrao,
        Boolean ativo

) {

    public static RegraAlertaResponseDTO fromEntity(RegraAlerta regraAlerta) {
        return new RegraAlertaResponseDTO(
                regraAlerta.getId(),
                regraAlerta.getTipoSensor(),
                regraAlerta.getValorMinimo(),
                regraAlerta.getValorMaximo(),
                regraAlerta.getNivelCriticidade(),
                regraAlerta.getMensagemPadrao(),
                regraAlerta.getAtivo()
        );
    }
}

