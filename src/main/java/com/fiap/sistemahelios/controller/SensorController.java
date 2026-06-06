package com.fiap.sistemahelios.controller;

import com.fiap.sistemahelios.dto.ReservaRequestDTO;
import com.fiap.sistemahelios.dto.ReservaResponseDTO;
import com.fiap.sistemahelios.dto.SensorRequestDTO;
import com.fiap.sistemahelios.dto.SensorResponseDTO;
import com.fiap.sistemahelios.service.ReservaService;
import com.fiap.sistemahelios.service.SensorService;
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
@RequestMapping("/api/sensores")
@Tag(name = "Sensores", description = "Endpoints para gerenciamento de sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    @Operation(
            summary = "Criar sensor",
            description = "Cria um novo sensor associado a um módulo habitacional."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Sensor criada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<SensorResponseDTO> criar(@Valid @RequestBody SensorRequestDTO requestDTO) {
        SensorResponseDTO novoSensor = sensorService.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSensor);
    }


    @GetMapping
    @Operation(
            summary = "Listar sensores",
            description = "Retorna uma lista completa de todos os sensores cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de sensores retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = SensorResponseDTO.class)
            )
    )
    public ResponseEntity<Page<SensorResponseDTO>> listarTodos(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<SensorResponseDTO> sensores = sensorService.listarTodos(pageable);
        return ResponseEntity.ok(sensores);
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar sensor por ID",
            description = "Retorna um sensor específico baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sensor encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Sensor não encontrado"
            )
    })
    public ResponseEntity<SensorResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(

            summary = "Atualizar sensor",
            description = "Atualiza os dados de um sensor existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sensor atualizada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Sensor não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<SensorResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody SensorRequestDTO requestDTO) {
        SensorResponseDTO sensorAtualizado = sensorService.atualizar(id, requestDTO);
        return ResponseEntity.ok(sensorAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar sensor",
            description = "Remove um sensor do sistema baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Sensor removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Sensor não encontrado"
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        sensorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
