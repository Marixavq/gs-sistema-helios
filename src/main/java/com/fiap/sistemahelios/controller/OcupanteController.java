package com.fiap.sistemahelios.controller;

import com.fiap.sistemahelios.dto.request.OcupanteRequestDTO;
import com.fiap.sistemahelios.dto.response.OcupanteResponseDTO;
import com.fiap.sistemahelios.dto.response.ReservaResponseDTO;
import com.fiap.sistemahelios.service.OcupanteService;
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
@RequestMapping("/api/ocupantes")
@Tag(name = "Ocupantes", description = "Endpoints para gerenciamento de ocupantes")
public class OcupanteController {


    @Autowired
    private OcupanteService ocupanteService;

    @PostMapping
    @Operation(
            summary = "Criar ocupante",
            description = "Cria um novo ocupante no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Ocupante criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<OcupanteResponseDTO> criar(@Valid @RequestBody OcupanteRequestDTO requestDTO) {
        OcupanteResponseDTO novoOcupante = ocupanteService.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoOcupante);
    }

    @GetMapping
    @Operation(
            summary = "Listar ocupantes",
            description = "Retorna uma lista completa de todos os ocupantes cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de ocupantes retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OcupanteResponseDTO.class)
            )
    )
    public ResponseEntity<Page<OcupanteResponseDTO>> listarTodos(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<OcupanteResponseDTO> ocupantes = ocupanteService.listarTodos(pageable);
        return ResponseEntity.ok(ocupantes);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar ocupante por ID",
            description = "Retorna um ocupante específico baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ocupante encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ocupante não encontrado"
            )
    })
    //com HATEOAS
    public ResponseEntity<EntityModel<OcupanteResponseDTO>> buscarPorId(@PathVariable Long id) {
        OcupanteResponseDTO responseDTO = ocupanteService.buscarPorId(id);

            EntityModel<OcupanteResponseDTO> responseComLinks =
                    EntityModel.of(responseDTO);

            responseComLinks.add(
                    linkTo(methodOn(OcupanteController.class)
                            .buscarPorId(id))
                            .withSelfRel()
            );

            responseComLinks.add(
                    linkTo(methodOn(OcupanteController.class)
                            .listarTodos(Pageable.unpaged()))
                            .withRel("todos")
            );

            responseComLinks.add(
                    linkTo(methodOn(ReservaController.class)
                            .buscarReservasPorOcupante(id, Pageable.unpaged()))
                            .withRel("reservas")
            );

            return ResponseEntity.ok(responseComLinks);
        }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar ocupante",
            description = "Atualiza os dados de um ocupante existente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ocupante atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ocupante não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<OcupanteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody OcupanteRequestDTO requestDTO) {
        return ResponseEntity.ok(ocupanteService.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar ocupante",
            description = "Remove um ocupante do sistema baseado no ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Ocupante removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ocupante não encontrado"
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ocupanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
