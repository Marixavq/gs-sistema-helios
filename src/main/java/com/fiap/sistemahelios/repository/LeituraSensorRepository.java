package com.fiap.sistemahelios.repository;

import com.fiap.sistemahelios.model.LeituraSensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeituraSensorRepository extends JpaRepository<LeituraSensor, Long> {

    Page<LeituraSensor> findBySensor_Id(Long idSensor, Pageable pageable);

    boolean existsBySensorId(Long id);
}