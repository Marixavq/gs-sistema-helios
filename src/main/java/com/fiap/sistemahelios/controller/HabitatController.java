package com.fiap.sistemahelios.controller;

import com.fiap.sistemahelios.dto.request.HabitatRequestDTO;
import com.fiap.sistemahelios.dto.response.HabitatResponseDTO;
import com.fiap.sistemahelios.service.HabitatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habitats")
@Tag(name = "Habitat", description = "Endpoints para gerenciamento de habitats")

public class HabitatController {

    @Autowired
    private HabitatService habitatService;

    @PostMapping
    @Operation(
            summary = "Criar habitat",
            description = "Cadastra um novo habitat no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Habitat cadastrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<HabitatResponseDTO> criar(@Valid @RequestBody HabitatRequestDTO requestDTO) {
        HabitatResponseDTO novoHabitat = habitatService.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHabitat);
    }

    @GetMapping
    @Operation(
            summary = "Listar habitats",
            description = "Retorna uma lista completa de todos os habitats cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de habitats retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = HabitatResponseDTO.class)
            )
    )
    public ResponseEntity<Page<HabitatResponseDTO>> listarTodos(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<HabitatResponseDTO> habitats = habitatService.listarTodos(pageable);
        return ResponseEntity.ok(habitats);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar habitat por ID",
            description = "Retorna um habitat específico baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Habitat encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Habitat não encontrado"
            )
    })
    public ResponseEntity<HabitatResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(habitatService.buscarPorId(id));
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar habitat",
            description = "Atualiza os dados de um habitat existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Habitat atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Habitat não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<HabitatResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody HabitatRequestDTO requestDTO) {
        return ResponseEntity.ok(habitatService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar habitat",
            description = "Remove um habitat do sistema baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Habitat removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Habitat não encontrado"
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        habitatService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
