package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.request.ReservaRequestDTO;
import com.fiap.sistemahelios.dto.response.ReservaResponseDTO;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.ModuloHabitacional;
import com.fiap.sistemahelios.model.Ocupante;
import com.fiap.sistemahelios.model.Reserva;
import com.fiap.sistemahelios.repository.ModuloHabitacionalRepository;
import com.fiap.sistemahelios.repository.OcupanteRepository;
import com.fiap.sistemahelios.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final OcupanteRepository ocupanteRepository;
    private final ModuloHabitacionalRepository moduloHabitacionalRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, OcupanteRepository ocupanteRepository, ModuloHabitacionalRepository moduloHabitacionalRepository) {
        this.reservaRepository = reservaRepository;
        this.ocupanteRepository = ocupanteRepository;
        this.moduloHabitacionalRepository = moduloHabitacionalRepository;
    }

    @Transactional
    public ReservaResponseDTO salvar(ReservaRequestDTO requestDTO) {
        Ocupante ocupante = ocupanteRepository.findById(requestDTO.idOcupante())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ocupante não encontrado com ID: " + requestDTO.idOcupante()));

        ModuloHabitacional modulo = moduloHabitacionalRepository.findById(requestDTO.idModulo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Módulo não encontrado com ID: " + requestDTO.idModulo()));

        Reserva reserva = new Reserva();
        reserva.setOcupante(ocupante);
        reserva.setModulo(modulo);
        reserva.setDataInicio(requestDTO.dataInicio());
        reserva.setDataFim(requestDTO.dataFim());
        reserva.setStatusReserva("ATIVO");

        Reserva reservaSalva = reservaRepository.save(reserva);

        return ReservaResponseDTO.fromEntity(reservaSalva);
    }

    @Transactional(readOnly = true)
    public Page<ReservaResponseDTO> listarTodos(Pageable pageable) {
        return reservaRepository.findAll(pageable)
                .map(ReservaResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public ReservaResponseDTO buscarPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Reserva não encontrada com ID: " + id));
        return ReservaResponseDTO.fromEntity(reserva);
    }


    @Transactional(readOnly = true)
    public Page<ReservaResponseDTO> buscarReservasPorOcupante(Long idOcupante, Pageable pageable) {
        ocupanteRepository.findById(idOcupante)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ocupante não encontrado com ID: " + idOcupante));

        return reservaRepository.findByOcupante_Id(idOcupante, pageable)
                .map(ReservaResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<ReservaResponseDTO> buscarReservasPorModulo(Long idModulo, Pageable pageable) {
        moduloHabitacionalRepository.findById(idModulo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Modulo não encontrado com ID: " + idModulo));

        return reservaRepository.findByModulo_Id(idModulo, pageable)
                .map(ReservaResponseDTO::fromEntity);
    }


    @Transactional
    public ReservaResponseDTO atualizar(Long id, ReservaRequestDTO requestDTO) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Reserva não encontrada com ID: " + id));

        reservaExistente.setDataInicio(requestDTO.dataInicio());
        reservaExistente.setDataFim(requestDTO.dataFim());
        reservaExistente.setStatusReserva(requestDTO.statusReserva());

        Reserva reservaAtualizada = reservaRepository.save(reservaExistente);

        return ReservaResponseDTO.fromEntity(reservaAtualizada);
    }

    @Transactional
    public void deletar(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Reserva não encontrada com ID: " + id);
        }
        reservaRepository.deleteById(id);
    }
}
