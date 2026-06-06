package com.fiap.sistemahelios.dto.dashboard;

import com.fiap.sistemahelios.model.Habitat;

public record HabitatResponseDTO(

        Long id,
        String nome,
        String tipoHabitat,
        Integer capacidadeTotal,
        String statusOperacional

) {

    public static HabitatResponseDTO fromEntity(Habitat habitat) {
        return new HabitatResponseDTO(
                habitat.getId(),
                habitat.getNome(),
                habitat.getTipoHabitat(),
                habitat.getCapacidadeTotal(),
                habitat.getStatusOperacional()
        );
    }
}

