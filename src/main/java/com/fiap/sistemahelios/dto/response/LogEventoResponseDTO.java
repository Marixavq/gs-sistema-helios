package com.fiap.sistemahelios.dto.response;

import com.fiap.sistemahelios.model.LogEvento;

import java.time.LocalDateTime;

public record LogEventoResponseDTO(

         Long id,
         String tipoEvento,
         String descricao,
         LocalDateTime dataHoraEvento,
         String origemEvento,
         String nivelEvento
) {

    public static LogEventoResponseDTO fromEntity(LogEvento logEvento) {
        return new LogEventoResponseDTO(
                logEvento.getId(),
                logEvento.getTipoEvento(),
                logEvento.getDescricao(),
                logEvento.getDataHoraEvento(),
                logEvento.getOrigemEvento(),
                logEvento.getNivelEvento()
        );
    }
}