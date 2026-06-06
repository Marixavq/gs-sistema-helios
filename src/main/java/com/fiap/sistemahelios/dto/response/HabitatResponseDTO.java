package com.fiap.sistemahelios.dto.response;

import com.fiap.sistemahelios.model.Habitat;

import java.time.LocalDate;

public record HabitatResponseDTO(

        Long id,
        String nome,
        String localizacao,
        String tipoHabitat,
        Integer capacidadeTotal,
        String statusOperacional,
        LocalDate datacCriacao,
        String nivelRisco

) {

    public static HabitatResponseDTO fromEntity(Habitat habitat) {
        return new HabitatResponseDTO(
                habitat.getId(),
                habitat.getNome(),
                habitat.getLocalizacao(),
                habitat.getTipoHabitat(),
                habitat.getCapacidadeTotal(),
                habitat.getStatusOperacional(),
                habitat.getDataCriacao(),
                habitat.getModulo().getNivelRisco()
        );
    }
}