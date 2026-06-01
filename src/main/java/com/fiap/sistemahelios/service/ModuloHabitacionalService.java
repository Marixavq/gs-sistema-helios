package com.fiap.sistemahelios.service;

import com.fiap.sistemahelios.dto.ModuloHabitacionalRequestDTO;
import com.fiap.sistemahelios.dto.ModuloHabitacionalResponseDTO;
import com.fiap.sistemahelios.exception.ModuloHabitacionalNaoEncontradoException;
import com.fiap.sistemahelios.exception.ReservaNaoEncontradaException;
import com.fiap.sistemahelios.exception.UsuarioNaoEncontradoException;
import com.fiap.sistemahelios.model.Habitat;
import com.fiap.sistemahelios.model.ModuloHabitacional;
import com.fiap.sistemahelios.repository.HabitatRepository;
import com.fiap.sistemahelios.repository.ModuloHabitacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModuloHabitacionalService {

    private final ModuloHabitacionalRepository moduloHabitacionalRepository;
    private final HabitatRepository habitatRepository;

    @Autowired
    public ModuloHabitacionalService(ModuloHabitacionalRepository moduloHabitacionalRepository, HabitatRepository habitatRepository) {
        this.moduloHabitacionalRepository = moduloHabitacionalRepository;
        this.habitatRepository = habitatRepository;
    }

    @Transactional
    public ModuloHabitacionalResponseDTO salvar (ModuloHabitacionalRequestDTO requestDTO) {

        Habitat habitat = habitatRepository.findById(requestDTO.idHabitat())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Habitat não encontrado com ID: " + requestDTO.idHabitat()));


        ModuloHabitacional moduloHabitacional = new ModuloHabitacional();
        moduloHabitacional.setHabitat(habitat);
        moduloHabitacional.setNomeModulo(requestDTO.nomeModulo());
        moduloHabitacional.setTipoModulo(requestDTO.tipoModulo());
        moduloHabitacional.setCapacidadeOcupantes(requestDTO.capacidadeOcupantes());
        moduloHabitacional.setStatusModulo(requestDTO.statusModulo());
        moduloHabitacional.setNivelRisco(requestDTO.nivelRisco());
        moduloHabitacional.setConsumoEnergia(requestDTO.consumoEnergia());
        moduloHabitacional.setConsumoAgua(requestDTO.consumoAgua());
        
        moduloHabitacionalRepository.save(moduloHabitacional);

        ModuloHabitacional moduloHabitacionalSalvo = moduloHabitacionalRepository.save(moduloHabitacional);

        return ModuloHabitacionalResponseDTO.fromEntity(moduloHabitacionalSalvo);
    }

    @Transactional(readOnly = true)
    public Page<ModuloHabitacionalResponseDTO> listarTodos(Pageable pageable) {
        Page<ModuloHabitacional> modulos = moduloHabitacionalRepository.findAll(pageable);

        return modulos.map(ModuloHabitacionalResponseDTO::fromEntity);
    }

    @Transactional(readOnly = true)
    public ModuloHabitacionalResponseDTO buscarPorId(Long id) {
        ModuloHabitacional moduloHabitacional = moduloHabitacionalRepository.findById(id)
                .orElseThrow(() -> new ModuloHabitacionalNaoEncontradoException("ModuloHabitacional não encontrado com ID: " + id));
        return ModuloHabitacionalResponseDTO.fromEntity(moduloHabitacional);
    }


    @Transactional
    public ModuloHabitacionalResponseDTO atualizar(Long id, ModuloHabitacionalRequestDTO requestDTO) {
        ModuloHabitacional moduloHabitacionalExistente = moduloHabitacionalRepository.findById(id)
                .orElseThrow(() -> new ReservaNaoEncontradaException("ModuloHabitacional não encontrado com ID: " + id));

        //moduloHabitacionalExistente.setHabitat(requestDTO.));
        moduloHabitacionalExistente.setNomeModulo(requestDTO.nomeModulo());
        moduloHabitacionalExistente.setTipoModulo(requestDTO.tipoModulo());
        moduloHabitacionalExistente.setCapacidadeOcupantes(requestDTO.capacidadeOcupantes());
        moduloHabitacionalExistente.setStatusModulo(requestDTO.statusModulo());
        moduloHabitacionalExistente.setNivelRisco(requestDTO.nivelRisco());
        moduloHabitacionalExistente.setConsumoEnergia(requestDTO.consumoEnergia());
        moduloHabitacionalExistente.setConsumoAgua(requestDTO.consumoAgua());

        ModuloHabitacional moduloHabitacionalAtualizado = moduloHabitacionalRepository.save(moduloHabitacionalExistente);

        return ModuloHabitacionalResponseDTO.fromEntity(moduloHabitacionalAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!moduloHabitacionalRepository.existsById(id)) {
            throw new ModuloHabitacionalNaoEncontradoException("ModuloHabitacional não encontrado com ID: " + id);
        }
        moduloHabitacionalRepository.deleteById(id);
    }



}
