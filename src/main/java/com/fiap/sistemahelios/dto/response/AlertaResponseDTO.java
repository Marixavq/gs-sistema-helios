package com.fiap.sistemahelios.dto.response;

import com.fiap.sistemahelios.model.Alerta;

import java.time.LocalDateTime;

public record AlertaResponseDTO (
        Long id,
        String nomeModulo,
        String nomeSensor,
        String tipoAlerta,
        String mensagem,
        String nivelCriticidade,
        LocalDateTime dataHoraAlerta,
        String statusAlerta
) {

    public static AlertaResponseDTO fromEntity(Alerta alerta) {
        return new AlertaResponseDTO(
                alerta.getId(),
                alerta.getModulo().getNomeModulo(),
                alerta.getSensor().getNomeSensor(),
                alerta.getTipoAlerta(),
                alerta.getMensagem(),
                alerta.getNivelCriticidade(),
                alerta.getDataHoraAlerta(),
                alerta.getStatusAlerta()
        );
    }
}