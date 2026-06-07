package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@Entity
@Table(name = "ocupante")
@Schema(
        name = "Ocupante",
        description = "Representa um ocupante no sistema Helios"
)
public class Ocupante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único do ocupante",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = "Nome do ocupante é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    @Schema(
            description = "Nome do ocupante",
            example = "João Silva",
            maxLength = 100
    )
    private String nome;

    @NotBlank(message = "Função do ocupante é obrigatória")
    @Size(max = 50, message = "A função deve ter no máximo 50 caracteres")
    @Column(nullable = false, length = 50)
    @Schema(
            description = "Função desempenhada pelo ocupante",
            example = "Engenheiro",
            maxLength = 50
    )
    private String funcao;

    @NotBlank(message = "Status do ocupante é obrigatório")
    @Size(max = 30, message = "O status deve ter no máximo 30 caracteres")
    @Column(name = "status_ocupante", nullable = false, length = 30)
    @Schema(
            description = "Status atual do ocupante",
            example = "ATIVO",
            maxLength = 30
    )
    private String statusOcupante;

    @Column(name = "data_registro", nullable = false, updatable = false)
    @Schema(
            description = "Data de registro do ocupante",
            example = "2026-01-10",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDate dataRegistro;


    public Ocupante() {
    }

    public Ocupante(String nome, String funcao, String statusOcupante) {
        this.nome = nome;
        this.funcao = funcao;
        this.statusOcupante = statusOcupante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getStatusOcupante() {
        return statusOcupante;
    }

    public void setStatusOcupante(String statusOcupante) {
        this.statusOcupante = statusOcupante;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @PrePersist
    protected void onCreate() {
        this.dataRegistro = LocalDate.now();
    }

}

