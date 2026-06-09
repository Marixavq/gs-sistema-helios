package com.fiap.sistemahelios.controller;

import com.fiap.sistemahelios.dto.request.AlertaRequestDTO;
import com.fiap.sistemahelios.dto.response.AlertaResponseDTO;
import com.fiap.sistemahelios.service.AlertaService;
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
@RequestMapping("/api/alertas")
@Tag(name = "Alertas", description = "Endpoints para gerenciamento de alertas")

public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @PostMapping
    @Operation(
            summary = "Criar alerta",
            description = "Cadastra um novo alerta no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "alerta cadastrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<AlertaResponseDTO> criar(@Valid @RequestBody AlertaRequestDTO requestDTO) {
        AlertaResponseDTO novoAlerta = alertaService.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlerta);
    }

    @GetMapping
    @Operation(
            summary = "Listar alertas",
            description = "Retorna uma lista completa de todos os alertas cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de alertas retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlertaResponseDTO.class)
            )
    )
    public ResponseEntity<Page<AlertaResponseDTO>> listarTodos(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<AlertaResponseDTO> alertas = alertaService.listarTodos(pageable);
        return ResponseEntity.ok(alertas);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar alerta por ID",
            description = "Retorna um alerta específico baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "alerta encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "alerta não encontrado"
            )
    })
    public ResponseEntity<AlertaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alertaService.buscarPorId(id));
    }


    //buscarAlertasPorModulo
    @GetMapping("/modulo/{idModulo}")
    @Operation(
            summary = "Buscar alertas por ID do modulo",
            description = "Retorna alertas específicas baseado no ID do modulo"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Alertas encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Alertas não encontrado"
            )
    })
    public ResponseEntity<Page<AlertaResponseDTO>> buscarAlertasPorModulo(
            @PathVariable Long idModulo,
            @PageableDefault(
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<AlertaResponseDTO> alertasModulo = alertaService.buscarAlertasPorModulo(idModulo, pageable);
        return ResponseEntity.ok(alertasModulo);
    }


    //buscarAlertasPorSensor
    @GetMapping("/sensor/{idSensor}")
    @Operation(
            summary = "Buscar alertas por ID do sensor",
            description = "Retorna alertas específicas baseado no ID do sensor"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Alertas encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Alertas não encontrado"
            )
    })
    public ResponseEntity<Page<AlertaResponseDTO>> buscarAlertasPorSensor(
            @PathVariable Long idSensor,
            @PageableDefault(
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<AlertaResponseDTO> alertasSensor = alertaService.buscarAlertasPorSensor(idSensor, pageable);
        return ResponseEntity.ok(alertasSensor);
    }



    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar alerta",
            description = "Atualiza os dados de um alerta existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "alerta atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "alerta não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<AlertaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AlertaRequestDTO requestDTO) {
        return ResponseEntity.ok(alertaService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar alerta",
            description = "Remove um alerta do sistema baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "alerta removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "alerta não encontrado"
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alertaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}