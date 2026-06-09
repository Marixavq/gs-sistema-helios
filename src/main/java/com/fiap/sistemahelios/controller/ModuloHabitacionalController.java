package com.fiap.sistemahelios.controller;

import com.fiap.sistemahelios.dto.request.ModuloHabitacionalRequestDTO;
import com.fiap.sistemahelios.dto.response.ModuloHabitacionalResponseDTO;
import com.fiap.sistemahelios.service.ModuloHabitacionalService;
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
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/modulos")
@Tag(name = "ModulosHabitacionais", description = "Endpoints para gerenciamento de ModulosHabitacionais")

public class ModuloHabitacionalController {


    @Autowired
    private ModuloHabitacionalService moduloHabitacionalService;

    @PostMapping
    @Operation(
            summary = "Criar ModuloHabitacional",
            description = "Cria um novo ModuloHabitacional associado a um habitat."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "ModuloHabitacional criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<ModuloHabitacionalResponseDTO> criar(@Valid @RequestBody ModuloHabitacionalRequestDTO requestDTO) {
        ModuloHabitacionalResponseDTO novoModuloHabitacional = moduloHabitacionalService.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoModuloHabitacional);
    }



    @GetMapping
    @Operation(
            summary = "Listar ModulosHabitacionais",
            description = "Retorna uma lista completa de todos os ModulosHabitacionais cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de ModulosHabitacionais retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ModuloHabitacionalResponseDTO.class)
            )
    )
    public ResponseEntity<Page<ModuloHabitacionalResponseDTO>> listarTodos(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<ModuloHabitacionalResponseDTO> modulos = moduloHabitacionalService.listarTodos(pageable);
        return ResponseEntity.ok(modulos);
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar ModuloHabitacional por ID",
            description = "Retorna uma ModuloHabitacional específica baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ModuloHabitacional encontrada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "ModuloHabitacional não encontrado"
            )
    })
    //com HATEOAS
    public ResponseEntity<EntityModel<ModuloHabitacionalResponseDTO>>  buscarPorId(@PathVariable Long id) {

        ModuloHabitacionalResponseDTO responseDTO = moduloHabitacionalService.buscarPorId(id);

        EntityModel<ModuloHabitacionalResponseDTO> responseComLinks =
                EntityModel.of(responseDTO);

        responseComLinks.add(
                linkTo(methodOn(ModuloHabitacionalController.class)
                        .buscarPorId(id))
                        .withSelfRel()
        );

        responseComLinks.add(
                linkTo(methodOn(ModuloHabitacionalController.class)
                        .listarTodos(Pageable.unpaged()))
                        .withRel("todos")
        );

        responseComLinks.add(
                linkTo(methodOn(SensorController.class)
                        .buscarSensoresPorModulo(id, Pageable.unpaged()))
                        .withRel("sensores")
        );

        responseComLinks.add(
                linkTo(methodOn(ReservaController.class)
                        .buscarReservasPorModulo(id, Pageable.unpaged()))
                        .withRel("reservas")
        );

        return ResponseEntity.ok(responseComLinks);
    }


    @PutMapping("/{id}")
    @Operation(

            summary = "Atualizar ModuloHabitacional",
            description = "Atualiza os dados de um ModuloHabitacional existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "ModuloHabitacional atualizada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "ModuloHabitacional não encontrada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<ModuloHabitacionalResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ModuloHabitacionalRequestDTO requestDTO) {
        ModuloHabitacionalResponseDTO modulosHabitacionalAtualizado = moduloHabitacionalService.atualizar(id, requestDTO);
        return ResponseEntity.ok(modulosHabitacionalAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar ModuloHabitacional",
            description = "Remove um ModuloHabitacional do sistema baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "ModuloHabitacional removida com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "ModuloHabitacional não encontrada"
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        moduloHabitacionalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

