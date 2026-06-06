package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.request.AcaoAutomaticaRequestDTO;
import com.fiap.sistemahelios.dto.response.AcaoAutomaticaResponseDTO;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.AcaoAutomatica;
import com.fiap.sistemahelios.model.Alerta;
import com.fiap.sistemahelios.repository.AcaoAutomaticaRepository;
import com.fiap.sistemahelios.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcaoAutomaticaService {

    private final AcaoAutomaticaRepository acaoAutomaticaRepository;
    private final AlertaRepository alertaRepository;

    @Autowired
    public AcaoAutomaticaService(AcaoAutomaticaRepository acaoAutomaticaRepository, AlertaRepository alertaRepository) {
        this.acaoAutomaticaRepository = acaoAutomaticaRepository;
        this.alertaRepository = alertaRepository;
    }

    @Transactional
    public AcaoAutomaticaResponseDTO salvar(AcaoAutomaticaRequestDTO requestDTO) {
        Alerta alerta = alertaRepository.findById(requestDTO.idAlerta())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Alerta não encontrado com ID: " + requestDTO.idAlerta()));

        AcaoAutomatica acaoAutomatica = new AcaoAutomatica();
        acaoAutomatica.setAlerta(alerta);
        acaoAutomatica.setDescricao(requestDTO.descricao());
        acaoAutomatica.setDataHoraExecucao(requestDTO.dataHoraExecucao());
        acaoAutomatica.setStatusAcao(requestDTO.statusAcao());

        AcaoAutomatica acaoAutomaticaSalva = acaoAutomaticaRepository.save(acaoAutomatica);

        return AcaoAutomaticaResponseDTO.fromEntity(acaoAutomaticaSalva);
    }

    @Transactional(readOnly = true)
    public Page<AcaoAutomaticaResponseDTO> listarTodos(Pageable pageable) {
        Page<AcaoAutomatica> acoes = acaoAutomaticaRepository.findAll(pageable);

        return acoes.map(AcaoAutomaticaResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public AcaoAutomaticaResponseDTO buscarPorId(Long id) {
        AcaoAutomatica acaoAutomatica = acaoAutomaticaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("acaoAutomatica não encontrado com ID: " + id));
        return AcaoAutomaticaResponseDTO.fromEntity(acaoAutomatica);
    }


    @Transactional
    public AcaoAutomaticaResponseDTO atualizar(Long id, AcaoAutomaticaRequestDTO requestDTO) {
        AcaoAutomatica acaoAutomaticaExistente = acaoAutomaticaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("acaoAutomatica não encontrado com ID: " + id));

        Alerta alerta = alertaRepository.findById(requestDTO.idAlerta())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Alerta não encontrado com ID: " + requestDTO.idAlerta()));

        acaoAutomaticaExistente.setAlerta(alerta);
        acaoAutomaticaExistente.setDescricao(requestDTO.descricao());
        acaoAutomaticaExistente.setDataHoraExecucao(requestDTO.dataHoraExecucao());
        acaoAutomaticaExistente.setStatusAcao(requestDTO.statusAcao());

        AcaoAutomatica acaoAutomaticaAtualizado = acaoAutomaticaRepository.save(acaoAutomaticaExistente);

        return AcaoAutomaticaResponseDTO.fromEntity(acaoAutomaticaAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!acaoAutomaticaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("acaoAutomatica não encontrado com ID: " + id);
        }
        acaoAutomaticaRepository.deleteById(id);
    }


}
