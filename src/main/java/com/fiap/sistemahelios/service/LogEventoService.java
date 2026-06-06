package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.request.LogEventoRequestDTO;
import com.fiap.sistemahelios.dto.response.LogEventoResponseDTO;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.LogEvento;
import com.fiap.sistemahelios.repository.LogEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogEventoService {

    private final LogEventoRepository logEventoRepository;

    @Autowired
    public LogEventoService(LogEventoRepository logEventoRepository) {
        this.logEventoRepository = logEventoRepository;
    }

    @Transactional
    public LogEventoResponseDTO salvar(LogEventoRequestDTO requestDTO) {

        LogEvento logEvento = new LogEvento();
        logEvento.setTipoEvento(requestDTO.tipoEvento());
        logEvento.setDescricao(requestDTO.descricao());
        logEvento.setDataHoraEvento(requestDTO.dataHoraEvento());
        logEvento.setOrigemEvento(requestDTO.origemEvento());
        logEvento.setNivelEvento(requestDTO.nivelEvento());

        LogEvento logEventoSalvo = logEventoRepository.save(logEvento);

        return LogEventoResponseDTO.fromEntity(logEventoSalvo);
    }

    @Transactional(readOnly = true)
    public Page<LogEventoResponseDTO> listarTodos(Pageable pageable) {
        Page<LogEvento> logs = logEventoRepository.findAll(pageable);

        return logs.map(LogEventoResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public LogEventoResponseDTO buscarPorId(Long id) {
        LogEvento logEvento = logEventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("LogEvento não encontrado com ID: " + id));
        return LogEventoResponseDTO.fromEntity(logEvento);
    }


    @Transactional
    public LogEventoResponseDTO atualizar(Long id, LogEventoRequestDTO requestDTO) {
        LogEvento logEventoExistente = logEventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("LogEvento não encontrado com ID: " + id));

        logEventoExistente.setTipoEvento(requestDTO.tipoEvento());
        logEventoExistente.setDescricao(requestDTO.descricao());
        logEventoExistente.setDataHoraEvento(requestDTO.dataHoraEvento());
        logEventoExistente.setOrigemEvento(requestDTO.origemEvento());
        logEventoExistente.setNivelEvento(requestDTO.nivelEvento());

        LogEvento logEventoAtualizado = logEventoRepository.save(logEventoExistente);

        return LogEventoResponseDTO.fromEntity(logEventoAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!logEventoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("LogEvento não encontrado com ID: " + id);
        }
        logEventoRepository.deleteById(id);
    }

}

