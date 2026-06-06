package com.fiap.sistemahelios.dto.request;

import java.time.LocalDateTime;

public record AcaoAutomaticaRequestDTO (
        Long idAlerta,

        String descricao,

        LocalDateTime dataHoraExecucao,

        String statusAcao
) {}