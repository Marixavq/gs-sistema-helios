package com.fiap.sistemahelios.dto.response;

import com.fiap.sistemahelios.model.ModuloHabitacional;

public record ModuloHabitacionalResponseDTO(
        Long id,
        String nomeHabitat,
        String nomeModulo,
        String tipoModulo,
        Integer capacidadeOcupantes,
        Integer ocupacaoAtual,
        String statusModulo,
        String nivelRisco,
        Double indiceRisco


) {

    public static ModuloHabitacionalResponseDTO fromEntity (ModuloHabitacional moduloHabitacional){
        return new ModuloHabitacionalResponseDTO(
                moduloHabitacional.getId(),
                moduloHabitacional.getHabitat().getNome(),
                moduloHabitacional.getNomeModulo(),
                moduloHabitacional.getTipoModulo(),
                moduloHabitacional.getCapacidadeOcupantes(),
                moduloHabitacional.getOcupacaoAtual(),
                moduloHabitacional.getStatusModulo(),
                moduloHabitacional.getNivelRisco(),
                moduloHabitacional.getIndiceRisco()
        );
    }
}

