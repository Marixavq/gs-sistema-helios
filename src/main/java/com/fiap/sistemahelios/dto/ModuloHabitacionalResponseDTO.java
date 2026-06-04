package com.fiap.sistemahelios.dto;

import com.fiap.sistemahelios.model.ModuloHabitacional;

public record ModuloHabitacionalResponseDTO(
        Long id,
        String nomeHabitat,
        String nomeModulo,
        String tipoModulo,
        Integer capacidadeOcupantes,
        Integer capacidadeAtual,
        String statusModulo,
        String nivelRisco,
        Double consumoEnergia,
        Double consumoAgua

) {

    public static ModuloHabitacionalResponseDTO fromEntity (ModuloHabitacional moduloHabitacional){
        return new ModuloHabitacionalResponseDTO(
                moduloHabitacional.getId(),
                moduloHabitacional.getHabitat().getNome(),
                moduloHabitacional.getNomeModulo(),
                moduloHabitacional.getTipoModulo(),
                moduloHabitacional.getCapacidadeOcupantes(),
                moduloHabitacional.getCapacidadeAtual(),
                moduloHabitacional.getStatusModulo(),
                moduloHabitacional.getNivelRisco(),
                moduloHabitacional.getConsumoEnergia(),
                moduloHabitacional.getConsumoAgua()
        );
    }
}

