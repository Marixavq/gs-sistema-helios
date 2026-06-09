package com.fiap.sistemahelios.service;
import com.fiap.sistemahelios.dto.request.RegraAlertaRequestDTO;
import com.fiap.sistemahelios.dto.request.SensorRequestDTO;
import com.fiap.sistemahelios.dto.response.RegraAlertaResponseDTO;
import com.fiap.sistemahelios.exception.OperacaoNaoPermitidaException;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.RegraAlerta;
import com.fiap.sistemahelios.repository.RegraAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegraAlertaService {


    private final RegraAlertaRepository regraAlertaRepository;

    @Autowired
    public RegraAlertaService(RegraAlertaRepository regraAlertaRepository) {
        this.regraAlertaRepository = regraAlertaRepository;
    }

    @Transactional
    public RegraAlertaResponseDTO salvar (RegraAlertaRequestDTO requestDTO) {

        validarValores(requestDTO);

        RegraAlerta regraAlerta = new RegraAlerta();

        regraAlerta.setTipoSensor(requestDTO.tipoSensor());
        regraAlerta.setValorMinimo(requestDTO.valorMinimo());
        regraAlerta.setValorMaximo(requestDTO.valorMaximo());
        regraAlerta.setNivelCriticidade(requestDTO.nivelCriticidade());
        regraAlerta.setPesoRisco(requestDTO.pesoRisco());
        regraAlerta.setMensagemPadrao(requestDTO.mensagemPadrao());
        regraAlerta.setAtivo(requestDTO.ativo());

        RegraAlerta regraAlertaSalvo = regraAlertaRepository.save(regraAlerta);

        return RegraAlertaResponseDTO.fromEntity(regraAlertaSalvo);
    }


    @Transactional(readOnly = true)
    public Page<RegraAlertaResponseDTO> listarTodos(Pageable pageable) {
        Page<RegraAlerta> regrasAlerta = regraAlertaRepository.findAll(pageable);

        return regrasAlerta.map(RegraAlertaResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public RegraAlertaResponseDTO buscarPorId(Long id) {
        RegraAlerta regraAlerta = regraAlertaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("RegraAlerta não encontrado com ID: " + id));
        return RegraAlertaResponseDTO.fromEntity(regraAlerta);
    }

    @Transactional
    public RegraAlertaResponseDTO atualizar(Long id, RegraAlertaRequestDTO requestDTO) {
        RegraAlerta regraAlertaExistente = regraAlertaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("RegraAlerta não encontrado com ID: " + id));

        regraAlertaExistente.setTipoSensor(requestDTO.tipoSensor());
        regraAlertaExistente.setValorMinimo(requestDTO.valorMinimo());
        regraAlertaExistente.setValorMaximo(requestDTO.valorMaximo());
        regraAlertaExistente.setNivelCriticidade(requestDTO.nivelCriticidade());
        regraAlertaExistente.setNivelCriticidade(requestDTO.nivelCriticidade());
        regraAlertaExistente.setPesoRisco(requestDTO.pesoRisco());
        regraAlertaExistente.setAtivo(requestDTO.ativo());

        RegraAlerta regraAlertaAtualizado = regraAlertaRepository.save(regraAlertaExistente);

        return RegraAlertaResponseDTO.fromEntity(regraAlertaAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!regraAlertaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("RegraAlerta não encontrado com ID: " + id);
        }
        regraAlertaRepository.deleteById(id);
    }

    private void validarValores(RegraAlertaRequestDTO requestDTO) {
        if (requestDTO.valorMinimo() >= requestDTO.valorMaximo()) {
            throw new OperacaoNaoPermitidaException("Não é possível cadastrar esses valores. O valor mínimo precisa ser inferior ao valor máximo.");
        }
    }

}
