package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.SensorRequestDTO;
import com.fiap.sistemahelios.dto.SensorResponseDTO;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.ModuloHabitacional;
import com.fiap.sistemahelios.model.Sensor;
import com.fiap.sistemahelios.repository.ModuloHabitacionalRepository;
import com.fiap.sistemahelios.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final ModuloHabitacionalRepository moduloHabitacionalRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository,ModuloHabitacionalRepository moduloHabitacionalRepository) {
        this.sensorRepository = sensorRepository;
        this.moduloHabitacionalRepository = moduloHabitacionalRepository;
    }

    @Transactional
    public SensorResponseDTO salvar(SensorRequestDTO requestDTO) {

        ModuloHabitacional moduloHabitacional = moduloHabitacionalRepository.findById(requestDTO.idModulo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("ModuloHabitacional não encontrado com ID: " + requestDTO.idModulo()));

        Sensor sensor = new Sensor();
        sensor.setModulo(moduloHabitacional);
        sensor.setNomeSensor(requestDTO.nomeSensor());
        sensor.setTipoSensor(requestDTO.tipoSensor());
        sensor.setStatusSensor(requestDTO.statusSensor());
        sensor.setUnidadeMedida(requestDTO.unidadeMedida());
        sensor.setLimiteMinimo(requestDTO.limiteMinimo());
        sensor.setLimiteMaximo(requestDTO.limiteMaximo());
        sensor.setIntervaloLeituraSegundos(requestDTO.in);
        sensor.setDataInstalacao(requestDTO.dataInstalacao());

        Sensor sensorSalvo = sensorRepository.save(sensor);

        return SensorResponseDTO.fromEntity(sensorSalvo);
    }


    @Transactional(readOnly = true)
    public Page<SensorResponseDTO> listarTodos(Pageable pageable) {
        Page<Sensor> sensores = sensorRepository.findAll(pageable);

        return sensores.map(SensorResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public SensorResponseDTO buscarPorId(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + id));
        return SensorResponseDTO.fromEntity(sensor);
    }

    @Transactional
    public SensorResponseDTO atualizar(Long id, SensorRequestDTO requestDTO) {
        Sensor sensorExistente = sensorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + id));

        sensorExistente.setNomeSensor(requestDTO.nomeSensor());
        sensorExistente.setTipoSensor(requestDTO.tipoSensor());
        sensorExistente.setStatusSensor(requestDTO.statusSensor());
        sensorExistente.setUnidadeMedida(requestDTO.unidadeMedida());
        sensorExistente.setLimiteMinimo(requestDTO.limiteMinimo());
        sensorExistente.setLimiteMaximo(requestDTO.limiteMaximo());
        sensorExistente.setDataInstalacao(requestDTO.dataInstalacao());

        Sensor sensorAtualizado = sensorRepository.save(sensorExistente);

        return SensorResponseDTO.fromEntity(sensorAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + id);
        }
        sensorRepository.deleteById(id);
    }

}
