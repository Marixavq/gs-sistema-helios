package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.request.HabitatRequestDTO;
import com.fiap.sistemahelios.dto.response.HabitatResponseDTO;
import com.fiap.sistemahelios.exception.OperacaoNaoPermitidaException;
import com.fiap.sistemahelios.exception.RecursoNaoEncontradoException;
import com.fiap.sistemahelios.model.Habitat;
import com.fiap.sistemahelios.repository.HabitatRepository;
import com.fiap.sistemahelios.repository.ModuloHabitacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitatService {

    private final HabitatRepository habitatRepository;
    private final ModuloHabitacionalRepository moduloHabitacionalRepository;

    @Autowired
    public HabitatService(HabitatRepository habitatRepository, ModuloHabitacionalRepository moduloHabitacionalRepository) {
        this.habitatRepository = habitatRepository;
        this.moduloHabitacionalRepository = moduloHabitacionalRepository;
    }

    @Transactional
    public HabitatResponseDTO salvar(HabitatRequestDTO requestDTO) {

        Habitat habitat = new Habitat();
        habitat.setNome(requestDTO.nome());
        habitat.setLocalizacao(requestDTO.localizacao());
        habitat.setTipoHabitat(requestDTO.tipoHabitat());
        habitat.setCapacidadeTotal(requestDTO.capacidadeTotal());
        habitat.setStatusOperacional(requestDTO.statusOperacional());

        Habitat habitatSalvo = habitatRepository.save(habitat);

        return HabitatResponseDTO.fromEntity(habitatSalvo);
    }

    @Transactional(readOnly = true)
    public Page<HabitatResponseDTO> listarTodos(Pageable pageable) {
        Page<Habitat> habitats = habitatRepository.findAll(pageable);

        return habitats.map(HabitatResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public HabitatResponseDTO buscarPorId(Long id) {
        Habitat habitat = habitatRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Habitat não encontrado com ID: " + id));
        return HabitatResponseDTO.fromEntity(habitat);
    }


    @Transactional
    public HabitatResponseDTO atualizar(Long id, HabitatRequestDTO requestDTO) {
        Habitat habitatExistente = habitatRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Habitat não encontrado com ID: " + id));

        habitatExistente.setNome(requestDTO.nome());
        habitatExistente.setLocalizacao(requestDTO.localizacao());
        habitatExistente.setTipoHabitat(requestDTO.tipoHabitat());
        habitatExistente.setCapacidadeTotal(requestDTO.capacidadeTotal());
        habitatExistente.setStatusOperacional(requestDTO.statusOperacional());

        Habitat habitatAtualizado = habitatRepository.save(habitatExistente);

        return HabitatResponseDTO.fromEntity(habitatAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!habitatRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Habitat não encontrado com ID: " + id);
        }
        if (moduloHabitacionalRepository.existsByHabitatId(id)) {
            throw new OperacaoNaoPermitidaException("Não é possível excluir o habitat pois existem módulos vinculados.");
        }

        habitatRepository.deleteById(id);
    }

}
