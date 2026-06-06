package com.fiap.sistemahelios.controller;

import com.fiap.sistemahelios.dto.request.AcaoAutomaticaRequestDTO;
import com.fiap.sistemahelios.dto.response.AcaoAutomaticaResponseDTO;
import com.fiap.sistemahelios.dto.response.AlertaResponseDTO;
import com.fiap.sistemahelios.service.AcaoAutomaticaService;
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
@RequestMapping("/api/acoes")
@Tag(name = "Acao Automatica", description = "Endpoints para gerenciamento de ações automáticas")

public class AcaoAutomaticaController {

    @Autowired
    private AcaoAutomaticaService acaoAutomaticaService;

    @PostMapping
    @Operation(
            summary = "Criar ação automática",
            description = "Cadastra um novo ação automática no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "ação automática cadastrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<AcaoAutomaticaResponseDTO> criar(@Valid @RequestBody AcaoAutomaticaRequestDTO requestDTO) {
        AcaoAutomaticaResponseDTO novaAcaoAutomatica = acaoAutomaticaService.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAcaoAutomatica);
    }

    @GetMapping
    @Operation(
            summary = "Listar ação automática",
            description = "Retorna uma lista completa de todos os ação automática cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de alertas retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlertaResponseDTO.class)
            )
    )
    public ResponseEntity<Page<AcaoAutomaticaResponseDTO>> listarTodos(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<AcaoAutomaticaResponseDTO> acoes = acaoAutomaticaService.listarTodos(pageable);
        return ResponseEntity.ok(acoes);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar ação automática por ID",
            description = "Retorna um ação automática específico baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ação automática encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "ação automática não encontrado"
            )
    })
    public ResponseEntity<AcaoAutomaticaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(acaoAutomaticaService.buscarPorId(id));
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar ação automática",
            description = "Atualiza os dados de um ação automática existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ação automática atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "ação automática não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<AcaoAutomaticaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AcaoAutomaticaRequestDTO requestDTO) {
        return ResponseEntity.ok(acaoAutomaticaService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar ação automática",
            description = "Remove um ação automática do sistema baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "ação automática removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "ação automática não encontrado"
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        acaoAutomaticaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}