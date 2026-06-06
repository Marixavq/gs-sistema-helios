package com.fiap.sistemahelios.repository;

import com.fiap.sistemahelios.model.Alerta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    Page<Alerta> findByModulo_Id(Long idModulo, Pageable pageable);

    Page<Alerta> findBySensor_Id(Long idSensor, Pageable pageable);
}
