package com.fiap.sistemahelios.repository;

import com.fiap.sistemahelios.model.ModuloHabitacional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuloHabitacionalRepository extends JpaRepository<ModuloHabitacional, Long> {

    boolean existsByHabitatId(Long id);
}