package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.request.AlertaRequestDTO;
import com.fiap.sistemahelios.dto.response.AlertaResponseDTO;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.*;
import com.fiap.sistemahelios.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;
    private final ModuloHabitacionalRepository moduloHabitacionalRepository;
    private final SensorRepository sensorRepository;


    @Autowired
    public AlertaService(AlertaRepository alertaRepository,ModuloHabitacionalRepository moduloHabitacionalRepository, SensorRepository sensorRepository) {
        this.alertaRepository = alertaRepository;
        this.moduloHabitacionalRepository = moduloHabitacionalRepository;
        this.sensorRepository = sensorRepository;
    }


    @Transactional
    public AlertaResponseDTO salvar (AlertaRequestDTO requestDTO) {
        ModuloHabitacional moduloHabitacional = moduloHabitacionalRepository.findById(requestDTO.idModulo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("ModuloHabitacional não encontrado com ID: " + requestDTO.idModulo()));

        Sensor sensor = sensorRepository.findById(requestDTO.idSensor())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + requestDTO.idSensor()));

        Alerta alerta = new Alerta();
        alerta.setModulo(moduloHabitacional);
        alerta.setSensor(sensor);
        alerta.setTipoAlerta(requestDTO.tipoAlerta());
        alerta.setMensagem(requestDTO.mensagem());
        alerta.setNivelCriticidade(requestDTO.nivelCriticidade());
        alerta.setDataHoraAlerta(requestDTO.dataHoraAlerta());
        alerta.setStatusAlerta(requestDTO.statusAlerta());

        Alerta alertaSalvo = alertaRepository.save(alerta);

        return AlertaResponseDTO.fromEntity(alertaSalvo);
    }


    @Transactional(readOnly = true)
    public Page<AlertaResponseDTO> listarTodos(Pageable pageable) {
        Page<Alerta> alertas = alertaRepository.findAll(pageable);

        return alertas.map(AlertaResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public AlertaResponseDTO buscarPorId(Long id) {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Alerta não encontrado com ID: " + id));
        return AlertaResponseDTO.fromEntity(alerta);
    }


    @Transactional(readOnly = true)
    public Page<AlertaResponseDTO> buscarAlertasPorModulo(Long idModulo, Pageable pageable) {
       moduloHabitacionalRepository.findById(idModulo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Modulo não encontrado com ID: " + idModulo));

       return alertaRepository.findByModulo_Id(idModulo, pageable)
                .map(AlertaResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<AlertaResponseDTO> buscarAlertasPorSensor(Long idSensor, Pageable pageable) {
       sensorRepository.findById(idSensor)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + idSensor));

       return alertaRepository.findBySensor_Id(idSensor, pageable)
                .map(AlertaResponseDTO::fromEntity);
    }



    @Transactional
    public AlertaResponseDTO atualizar(Long id, AlertaRequestDTO requestDTO) {
        Alerta alertaExistente = alertaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Alerta não encontrado com ID: " + id));

        ModuloHabitacional moduloHabitacional = moduloHabitacionalRepository.findById(requestDTO.idModulo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("ModuloHabitacional não encontrado com ID: " + requestDTO.idModulo()));

        Sensor sensor = sensorRepository.findById(requestDTO.idSensor())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + requestDTO.idSensor()));

        alertaExistente.setModulo(moduloHabitacional);
        alertaExistente.setSensor(sensor);
        alertaExistente.setTipoAlerta(requestDTO.tipoAlerta());
        alertaExistente.setMensagem(requestDTO.mensagem());
        alertaExistente.setNivelCriticidade(requestDTO.nivelCriticidade());
        alertaExistente.setDataHoraAlerta(requestDTO.dataHoraAlerta());
        alertaExistente.setStatusAlerta(requestDTO.statusAlerta());

        Alerta alertaAtualizado = alertaRepository.save(alertaExistente);

        return AlertaResponseDTO.fromEntity(alertaAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!alertaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Alerta não encontrado com ID: " + id);
        }
        alertaRepository.deleteById(id);
    }

}
