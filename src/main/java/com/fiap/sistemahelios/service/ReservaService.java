package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.ReservaRequestDTO;
import com.fiap.sistemahelios.dto.ReservaResponseDTO;
import com.fiap.sistemahelios.exception.ModuloHabitacionalNaoEncontradoException;
import com.fiap.sistemahelios.exception.ReservaNaoEncontradaException;
import com.fiap.sistemahelios.exception.UsuarioNaoEncontradoException;
import com.fiap.sistemahelios.model.ModuloHabitacional;
import com.fiap.sistemahelios.model.Reserva;
import com.fiap.sistemahelios.model.Usuario;
import com.fiap.sistemahelios.repository.ModuloHabitacionalRepository;
import com.fiap.sistemahelios.repository.ReservaRepository;
import com.fiap.sistemahelios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModuloHabitacionalRepository moduloHabitacionalRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, ModuloHabitacionalRepository moduloHabitacionalRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.moduloHabitacionalRepository = moduloHabitacionalRepository;
    }

    @Transactional
    public ReservaResponseDTO salvar(ReservaRequestDTO requestDTO) {
        Usuario usuario = usuarioRepository.findById(requestDTO.idUsuario())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + requestDTO.idUsuario()));

        ModuloHabitacional modulo = moduloHabitacionalRepository.findById(requestDTO.idModulo())
                .orElseThrow(() -> new ModuloHabitacionalNaoEncontradoException("Módulo não encontrado com ID: " + requestDTO.idModulo()));

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
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
                .orElseThrow(() -> new ReservaNaoEncontradaException("Reserva não encontrada com ID: " + id));
        return ReservaResponseDTO.fromEntity(reserva);
    }




    @Transactional(readOnly = true)
    public Page<ReservaResponseDTO> buscarReservaPorIdUsuario(Long idUsuario, Pageable pageable) {

        return reservaRepository.findReservaByUsuarioId(idUsuario, pageable)
                .map(ReservaResponseDTO::fromEntity);
    }




    @Transactional
    public ReservaResponseDTO atualizar(Long id, ReservaRequestDTO requestDTO) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNaoEncontradaException("Reserva não encontrada com ID: " + id));

        reservaExistente.setDataInicio(requestDTO.dataInicio());
        reservaExistente.setDataFim(requestDTO.dataFim());
        reservaExistente.setStatusReserva(requestDTO.statusReserva());

        Reserva reservaAtualizada = reservaRepository.save(reservaExistente);

        return ReservaResponseDTO.fromEntity(reservaAtualizada);
    }

    @Transactional
    public void deletar(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new ReservaNaoEncontradaException("Reserva não encontrada com ID: " + id);
        }
        reservaRepository.deleteById(id);
    }
}
