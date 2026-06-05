package com.fiap.sistemahelios.dto;

import java.time.LocalDateTime;

public record AcaoAutomaticaRequestDTO (
        Long idAlerta,

        String descricao,

        LocalDateTime dataHoraExecucao,

        String statusAcao
) {}