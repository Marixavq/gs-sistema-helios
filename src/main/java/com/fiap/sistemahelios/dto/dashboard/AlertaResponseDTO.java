package com.fiap.sistemahelios.dto.dashboard;

import com.fiap.sistemahelios.model.Alerta;

import java.time.LocalDateTime;

public record AlertaResponseDTO(
        Long id,
        String nomeSensor,
        String tipoAlerta,
        String mensagem,
        String nivelCriticidade,
        LocalDateTime dataHoraAlerta
) {

    public static AlertaResponseDTO fromEntity(Alerta alerta) {
        return new AlertaResponseDTO(
                alerta.getId(),
                alerta.getSensor().getNomeSensor(),
                alerta.getTipoAlerta(),
                alerta.getMensagem(),
                alerta.getNivelCriticidade(),
                alerta.getDataHoraAlerta()
        );
    }
}