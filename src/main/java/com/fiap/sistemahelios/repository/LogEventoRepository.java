package com.fiap.sistemahelios.repository;

import com.fiap.sistemahelios.model.LogEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEventoRepository extends JpaRepository<LogEvento, Long> {
}
