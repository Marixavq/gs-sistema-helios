package com.fiap.sistemahelios.controller;

import com.fiap.sistemahelios.dto.LogEventoRequestDTO;
import com.fiap.sistemahelios.dto.LogEventoResponseDTO;
import com.fiap.sistemahelios.service.LogEventoService;
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

public class LogEventoController {

    @Autowired
    private LogEventoService logEventoService;

    @PostMapping
    @Operation(
            summary = "Criar LogEvento",
            description = "Cadastra um novo LogEvento no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "LogEvento cadastrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<LogEventoResponseDTO> criar(@Valid @RequestBody LogEventoRequestDTO requestDTO) {
        LogEventoResponseDTO novoLogEvento = logEventoService.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLogEvento);
    }

    @GetMapping
    @Operation(
            summary = "Listar LogEvento",
            description = "Retorna uma lista completa de todos os LogEvento cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de LogEvento retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = LogEventoResponseDTO.class)
            )
    )
    public ResponseEntity<Page<LogEventoResponseDTO>> listarTodos(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<LogEventoResponseDTO> logs = logEventoService.listarTodos(pageable);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar LogEvento por ID",
            description = "Retorna um LogEvento específico baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "LogEvento encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "LogEvento não encontrado"
            )
    })
    public ResponseEntity<LogEventoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(logEventoService.buscarPorId(id));
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar LogEvento",
            description = "Atualiza os dados de um LogEvento existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "LogEvento atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "LogEvento não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<LogEventoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LogEventoRequestDTO requestDTO) {
        return ResponseEntity.ok(logEventoService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar LogEvento",
            description = "Remove um LogEvento do sistema baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "LogEvento removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "LogEvento não encontrado"
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        logEventoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
