package com.fiap.sistemahelios.repository;

import com.fiap.sistemahelios.model.AcaoAutomatica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcaoAutomaticaRepository extends JpaRepository<AcaoAutomatica, Long> {

    boolean existsByAlertaId(Long id);

}
