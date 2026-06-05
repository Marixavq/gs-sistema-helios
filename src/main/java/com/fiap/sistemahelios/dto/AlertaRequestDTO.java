package com.fiap.sistemahelios.dto;

import java.time.LocalDateTime;

public record AlertaRequestDTO(

         Long idModulo,
         Long idSensor,
         String tipoAlerta,
         String mensagem,
         String nivelCriticidade,
         LocalDateTime dataHoraAlerta,
         String statusAlerta

){
}
