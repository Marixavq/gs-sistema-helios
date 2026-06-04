package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.LeituraSensorRequestDTO;
import com.fiap.sistemahelios.dto.LeituraSensorResponseDTO;
import com.fiap.sistemahelios.exception.LeituraSensorNaoEncontradoException;
import com.fiap.sistemahelios.exception.SensorNaoEncontradoException;
import com.fiap.sistemahelios.model.LeituraSensor;
import com.fiap.sistemahelios.model.Sensor;
import com.fiap.sistemahelios.repository.LeituraSensorRepository;
import com.fiap.sistemahelios.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public class LeituraSensorService {

    private final LeituraSensorRepository leituraSensorRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public LeituraSensorService(LeituraSensorRepository leituraSensorRepository, SensorRepository sensorRepository) {
        this.leituraSensorRepository = leituraSensorRepository;
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public LeituraSensorResponseDTO salvar (LeituraSensorRequestDTO requestDTO) {

        Sensor sensor = sensorRepository.findById(requestDTO.idSensor())
                .orElseThrow(() -> new SensorNaoEncontradoException("Sensor não encontrado com ID: " + requestDTO.idSensor()));

        LeituraSensor leituraSensor = new LeituraSensor();
        leituraSensor.setSensor(sensor);
        leituraSensor.setValorLeitura(requestDTO.valorLeitura());
        leituraSensor.setDataHoraLeitura(requestDTO.dataHoraLeitura());
        leituraSensor.setStatusLeitura(requestDTO.statusLeitura());

        leituraSensorRepository.save(leituraSensor);

        LeituraSensor leituraSensorSalvo = leituraSensorRepository.save(leituraSensor);

        return LeituraSensorResponseDTO.fromEntity(leituraSensorSalvo);
    }

    @Transactional(readOnly = true)
    public Page<LeituraSensorResponseDTO> listarTodos(Pageable pageable) {
        Page<LeituraSensor> leituraSensores = leituraSensorRepository.findAll(pageable);

        return leituraSensores.map(LeituraSensorResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public LeituraSensorResponseDTO buscarPorId(Long id) {
        LeituraSensor leituraSensor = leituraSensorRepository.findById(id)
                .orElseThrow(() -> new LeituraSensorNaoEncontradoException("LeituraSensor não encontrado com ID: " + id));
        return LeituraSensorResponseDTO.fromEntity(leituraSensor);
    }


    @Transactional
    public LeituraSensorResponseDTO atualizar(Long id, LeituraSensorRequestDTO requestDTO) {
        LeituraSensor leituraSensorExistente = leituraSensorRepository.findById(id)
                .orElseThrow(() -> new LeituraSensorNaoEncontradoException("LeituraSensor não encontrado com ID: " + id));

        //moduloHabitacionalExistente.setHabitat(requestDTO.));
        leituraSensorExistente.setStatusLeitura(requestDTO.statusLeitura());
        leituraSensorExistente.setDataHoraLeitura(requestDTO.dataHoraLeitura());
        leituraSensorExistente.setStatusLeitura(requestDTO.statusLeitura());

        LeituraSensor leituraSensorAtualizado = leituraSensorRepository.save(leituraSensorExistente);

        return LeituraSensorResponseDTO.fromEntity(leituraSensorAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!leituraSensorRepository.existsById(id)) {
            throw new LeituraSensorNaoEncontradoException("LeituraSensor não encontrado com ID: " + id);
        }
        leituraSensorRepository.deleteById(id);
    }


}
