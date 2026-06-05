package com.fiap.sistemahelios.dto;

import java.time.LocalDateTime;

public record LogEventoRequestDTO(

         String tipoEvento,
         String descricao,
         LocalDateTime dataHoraEvento,
         String origemEvento,
         String nivelEvento
) {
}
