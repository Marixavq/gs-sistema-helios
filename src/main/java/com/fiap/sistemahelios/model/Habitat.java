package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "habitat")
@Schema(
        name = "Habitat",
        description = "Representa um habitat no sistema Helios"
)
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único do habitat",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = "Nome do habitat é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    @Schema(
            description = "Nome do habitat",
            example = "Artemis Alpha",
            minLength = 3,
            maxLength = 100
    )
    private String nome;

    @NotBlank(message = "Localização é obrigatória")
    @Size(max = 100, message = "A localização deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    @Schema(
            description = "Localização do habitat",
            example = "Lua - Setor Norte",
            maxLength = 100
    )
    private String localizacao;

    @NotBlank(message = "Tipo de habitat é obrigatório")
    @Size(max = 50, message = "O tipo de habitat deve ter  no máximo 50 caracteres")
    @Column(name = "tipo_habitat", nullable = false, length = 50)
    @Schema(
            description = "Tipo do habitat",
            example = "Pesquisa",
            maxLength = 50
    )
    private String tipoHabitat;

    @NotNull(message = "Capacidade total é obrigatória")
    @Positive(message = "A capacidade total deve ser maior que zero")
    @Column(name = "capacidade_total", nullable = false)
    @Schema(
            description = "Capacidade total do habitat",
            example = "80"
    )
    private Integer capacidadeTotal;

    @NotBlank(message = "Status operacional é obrigatório")
    @Size(max = 30, message = "O status operacional deve ter no máximo 30 caracteres")
    @Column(name = "status_operacional", nullable = false, length = 30)
    @Schema(
            description = "Status operacional do habitat",
            example = "Operacional"
    )
    private String statusOperacional;

    @Column(name = "data_criacao", updatable = false)
    private LocalDate dataCriacao;

    public Habitat() {
    }

    public Habitat(String nome, String localizacao, String tipoHabitat, Integer capacidadeTotal, String statusOperacional) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoHabitat = tipoHabitat;
        this.capacidadeTotal = capacidadeTotal;
        this.statusOperacional = statusOperacional;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public void setTipoHabitat(String tipoHabitat) {
        this.tipoHabitat = tipoHabitat;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public String getStatusOperacional() {
        return statusOperacional;
    }

    public void setStatusOperacional(String statusOperacional) {
        this.statusOperacional = statusOperacional;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDate.now();
    }
}
