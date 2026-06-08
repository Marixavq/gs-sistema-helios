package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.request.SensorRequestDTO;
import com.fiap.sistemahelios.dto.response.SensorResponseDTO;
import com.fiap.sistemahelios.exception.OperacaoNaoPermitidaException;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.ModuloHabitacional;
import com.fiap.sistemahelios.model.Sensor;
import com.fiap.sistemahelios.repository.AlertaRepository;
import com.fiap.sistemahelios.repository.LeituraSensorRepository;
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
    private final LeituraSensorRepository leituraSensorRepository;
    private final AlertaRepository alertaRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository,ModuloHabitacionalRepository moduloHabitacionalRepository,LeituraSensorRepository leituraSensorRepository, AlertaRepository alertaRepository) {
        this.sensorRepository = sensorRepository;
        this.moduloHabitacionalRepository = moduloHabitacionalRepository;
        this.leituraSensorRepository = leituraSensorRepository;
        this.alertaRepository = alertaRepository;
    }

    @Transactional
    public SensorResponseDTO salvar(SensorRequestDTO requestDTO) {

        ModuloHabitacional moduloHabitacional = moduloHabitacionalRepository.findById(requestDTO.idModulo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("ModuloHabitacional não encontrado com ID: " + requestDTO.idModulo()));

        validarLimites(requestDTO);

        Sensor sensor = new Sensor();
        sensor.setModulo(moduloHabitacional);
        sensor.setNomeSensor(requestDTO.nomeSensor());
        sensor.setTipoSensor(requestDTO.tipoSensor());
        sensor.setStatusSensor(requestDTO.statusSensor());
        sensor.setUnidadeMedida(requestDTO.unidadeMedida());
        sensor.setLimiteMinimo(requestDTO.limiteMinimo());
        sensor.setLimiteMaximo(requestDTO.limiteMaximo());
        sensor.setIntervaloLeituraSegundos(requestDTO.intervaloLeituraSegundos());

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

    @Transactional(readOnly = true)
    public Page<SensorResponseDTO> buscarSensoresPorModulo(Long idModulo, Pageable pageable) {
        moduloHabitacionalRepository.findById(idModulo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("ModuloHabitacional não encontrado com ID: " + idModulo));

        return sensorRepository.findByModulo_Id(idModulo,pageable)
                .map(SensorResponseDTO::fromEntity);
    }

    @Transactional
    public SensorResponseDTO atualizar(Long id, SensorRequestDTO requestDTO) {
        Sensor sensorExistente = sensorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + id));

        validarLimites(requestDTO);

        sensorExistente.setNomeSensor(requestDTO.nomeSensor());
        sensorExistente.setTipoSensor(requestDTO.tipoSensor());
        sensorExistente.setStatusSensor(requestDTO.statusSensor());
        sensorExistente.setUnidadeMedida(requestDTO.unidadeMedida());
        sensorExistente.setLimiteMinimo(requestDTO.limiteMinimo());
        sensorExistente.setLimiteMaximo(requestDTO.limiteMaximo());
        sensorExistente.setIntervaloLeituraSegundos(requestDTO.intervaloLeituraSegundos());

        Sensor sensorAtualizado = sensorRepository.save(sensorExistente);

        return SensorResponseDTO.fromEntity(sensorAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Sensor não encontrado com ID: " + id);
        }

        if (leituraSensorRepository.existsBySensorId(id)) {
            throw new OperacaoNaoPermitidaException("Não é possível excluir o sensor pois existem leituras vinculadas.");
        }

        if (alertaRepository.existsBySensorId(id)) {
            throw new OperacaoNaoPermitidaException("Não é possível excluir o sensor pois existem alertas vinculados.");
        }

        sensorRepository.deleteById(id);
    }


    // regras de neǵocio

    private void validarLimites(SensorRequestDTO requestDTO) {
        if (requestDTO.limiteMinimo() != null &&
                requestDTO.limiteMaximo() != null &&
                requestDTO.limiteMinimo() >= requestDTO.limiteMaximo()) {
            throw new OperacaoNaoPermitidaException("Não é possível cadastrar esses limites. O limite mínimo precisa ser inferior ao limite máximo.");
        }
    }

}
