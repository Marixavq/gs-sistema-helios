package com.fiap.sistemahelios.dto;

import com.fiap.sistemahelios.model.Ocupante;
import com.fiap.sistemahelios.model.Reserva;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record OcupanteResponseDTO(

        Long id,

        String nome,

        String funcao,

        String statusOcupante,

        LocalDate dataRegistro

) {

    public static OcupanteResponseDTO fromEntity (Ocupante ocupante){
        return new OcupanteResponseDTO(
                ocupante.getId(),
                ocupante.getNome(),
                ocupante.getFuncao(),
                ocupante.getStatusOcupante(),
                ocupante.getDataRegistro()
        );
    }
}