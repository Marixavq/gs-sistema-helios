package com.fiap.sistemahelios.dto;

import com.fiap.sistemahelios.model.Reserva;

import java.time.LocalDate;

public record ReservaResponseDTO(

            Long id,
            String nomeUsuario,
            String nomeModulo,
            LocalDate dataInicio,
            LocalDate dataFim,
            String statusReserva

    ) {

        public static ReservaResponseDTO fromEntity (Reserva reserva){
        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getUsuario().getNome(),
                reserva.getModulo().getNomeModulo(),
                reserva.getDataInicio(),
                reserva.getDataFim(),
                reserva.getStatusReserva()
        );
    }
}