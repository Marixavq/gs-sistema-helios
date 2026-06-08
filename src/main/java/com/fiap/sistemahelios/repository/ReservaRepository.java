package com.fiap.sistemahelios.repository;

import com.fiap.sistemahelios.model.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Page<Reserva> findByOcupante_Id(Long idOcupante, Pageable pageable);

    Page<Reserva> findByModulo_Id( Long idModulo, Pageable pageable);

    boolean existsByModuloId(Long id);

    boolean existsByOcupanteId(Long id);
}
