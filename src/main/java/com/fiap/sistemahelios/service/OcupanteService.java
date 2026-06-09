package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.request.OcupanteRequestDTO;
import com.fiap.sistemahelios.dto.response.OcupanteResponseDTO;
import com.fiap.sistemahelios.exception.OperacaoNaoPermitidaException;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.Ocupante;
import com.fiap.sistemahelios.repository.ModuloHabitacionalRepository;
import com.fiap.sistemahelios.repository.OcupanteRepository;
import com.fiap.sistemahelios.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OcupanteService {

    private final OcupanteRepository ocupanteRepository;
    private final ReservaRepository reservaRepository;

    @Autowired
    public OcupanteService(OcupanteRepository ocupanteRepository, ReservaRepository reservaRepository) {
        this.ocupanteRepository = ocupanteRepository;
        this.reservaRepository = reservaRepository;
    }

    @Transactional
    public OcupanteResponseDTO salvar (OcupanteRequestDTO requestDTO) {

        Ocupante ocupante = new Ocupante();
        ocupante.setNome(requestDTO.nome());
        ocupante.setFuncao(requestDTO.funcao());
        ocupante.setStatusOcupante(requestDTO.statusOcupante());

        Ocupante ocupanteSalvo = ocupanteRepository.save(ocupante);

        return OcupanteResponseDTO.fromEntity(ocupanteSalvo);
    }


    @Transactional(readOnly = true)
    public Page<OcupanteResponseDTO> listarTodos(Pageable pageable) {
        Page<Ocupante> ocupantes = ocupanteRepository.findAll(pageable);

        return ocupantes.map(OcupanteResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public OcupanteResponseDTO buscarPorId(Long id) {
        Ocupante ocupante = ocupanteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ocupante não encontrado com ID: " + id));
        return OcupanteResponseDTO.fromEntity(ocupante);
    }

    @Transactional
    public OcupanteResponseDTO atualizar(Long id, OcupanteRequestDTO requestDTO) {
        Ocupante ocupanteExistente = ocupanteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ocupante não encontrado com ID: " + id));

        ocupanteExistente.setNome(requestDTO.nome());
        ocupanteExistente.setFuncao(requestDTO.funcao());
        ocupanteExistente.setStatusOcupante(requestDTO.statusOcupante());

        Ocupante ocupanteAtualizado = ocupanteRepository.save(ocupanteExistente);

        return OcupanteResponseDTO.fromEntity(ocupanteAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!ocupanteRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Ocupante não encontrado com ID: " + id);
        }

        if (reservaRepository.existsByOcupanteId(id)) {
            throw new OperacaoNaoPermitidaException("Não é possível excluir o ocupante pois existem reservas vinculadas.");
        }

        ocupanteRepository.deleteById(id);
    }


}