package com.fiap.sistemahelios.repository;

import com.fiap.sistemahelios.model.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Page<Sensor> findByModuloIdModulo(Long idModulo, Pageable pageable);

}