package com.fiap.sistemahelios.dto;

import com.fiap.sistemahelios.model.AcaoAutomatica;
import com.fiap.sistemahelios.model.Alerta;

import java.time.LocalDateTime;

public record AcaoAutomaticaResponseDTO  (

        Long id,

        String tipoAlerta,

        String nivelCriticidade,

        String descricao,

        LocalDateTime dataHoraExecucao,

        String statusAcao

) {

    public static AcaoAutomaticaResponseDTO fromEntity(AcaoAutomatica acaoAutomatica) {
        return new AcaoAutomaticaResponseDTO(
                acaoAutomatica.getId(),
                acaoAutomatica.getAlerta().getTipoAlerta(),
                acaoAutomatica.getAlerta().getNivelCriticidade(),
                acaoAutomatica.getDescricao(),
                acaoAutomatica.getDataHoraExecucao(),
                acaoAutomatica.getStatusAcao()
        );
    }
}