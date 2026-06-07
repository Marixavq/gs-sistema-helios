package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "modulo_habitacional")
@Schema(
        name = "Modulo Habitacional",
        description = "Representa um modulo habitacional no sistema Helios"
)
public class ModuloHabitacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único do módulo habitacional",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @ManyToOne
    @NotNull(message = "Habitat é obrigatório")
    @JoinColumn(name = "id_habitat", nullable = false)
    @Schema(
            description = "Habitat associado a ModuloHabitacional",
            example = "1"
    )
    private Habitat habitat;

    @NotBlank(message = "Nome do módulo é obrigatório")
    @Size(max = 100, message = "O nome do módulo deve ter no máximo 100 caracteres")
    @Column(name = "nome_modulo", nullable = false, length = 100)
    @Schema(
            description = "Nome do módulo habitacional",
            example = "Módulo Aurora",
            maxLength = 100
    )
    private String nomeModulo;

    @NotBlank(message = "Tipo do módulo é obrigatório")
    @Size(max = 50, message = "O tipo do módulo deve ter no máximo 50 caracteres")
    @Column(name = "tipo_modulo", nullable = false, length = 50)
    @Schema(
            description = "Tipo do módulo habitacional",
            example = "Residencial",
            maxLength = 50
    )
    private String tipoModulo;

    @NotNull(message = "Capacidade de ocupantes é obrigatória")
    @Positive(message = "A capacidade deve ser maior que zero")
    @Column(name = "capacidade_ocupantes", nullable = false)
    @Schema(
            description = "Capacidade máxima de ocupantes do módulo",
            example = "8"
    )
    private Integer capacidadeOcupantes;

    @NotNull(message = "Capacidade de ocupantes é obrigatória")
    @PositiveOrZero(message = "A capacidade deve ser maior ou igual a zero")
    @Column(name = "ocupacao_atual", nullable = false)
    @Schema(
            description = "Quantidade atual de ocupantes no módulo",
            example = "5"
    )
    private Integer ocupacaoAtual;

    @NotBlank(message = "Status do módulo é obrigatório")
    @Size(max = 30, message = "O status do módulo deve ter no máximo 30 caracteres")
    @Column(name = "status_modulo", nullable = false, length = 30)
    @Schema(
            description = "Status operacional do módulo",
            example = "ATIVO",
            maxLength = 30
    )
    private String statusModulo;

    @NotBlank(message = "Nível de risco é obrigatório")
    @Size(max = 20, message = "O nível de risco deve ter no máximo 20 caracteres")
    @Column(name = "nivel_risco", nullable = false, length = 20)
    @Schema(
            description = "Classificação do nível de risco do módulo",
            example = "BAIXO",
            maxLength = 20
    )
    private String nivelRisco;

    @NotNull(message = "Indice de risco é obrigatório")
    @PositiveOrZero(message = "O indice de risco  deve ser maior ou igual a zero")
    @Column(name = "indice_risco", nullable = false)
    @Schema(
            description = "Índice numérico de risco do módulo",
            example = "12.75"
    )
    private Double indiceRisco;


    public ModuloHabitacional() {
    }

    public ModuloHabitacional(Habitat habitat, String nomeModulo, String tipoModulo, Integer capacidadeOcupantes, Integer ocupacaoAtual, String statusModulo, String nivelRisco, Double indiceRisco) {
        this.habitat = habitat;
        this.nomeModulo = nomeModulo;
        this.tipoModulo = tipoModulo;
        this.capacidadeOcupantes = capacidadeOcupantes;
        this.ocupacaoAtual = ocupacaoAtual;
        this.statusModulo = statusModulo;
        this.nivelRisco = nivelRisco;
        this.indiceRisco = indiceRisco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public String getTipoModulo() {
        return tipoModulo;
    }

    public void setTipoModulo(String tipoModulo) {
        this.tipoModulo = tipoModulo;
    }

    public Integer getCapacidadeOcupantes() {
        return capacidadeOcupantes;
    }

    public void setCapacidadeOcupantes(Integer capacidadeOcupantes) {
        this.capacidadeOcupantes = capacidadeOcupantes;
    }

    public Integer getOcupacaoAtual() {
        return ocupacaoAtual;
    }

    public void setOcupacaoAtual(Integer ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }

    public String getStatusModulo() {
        return statusModulo;
    }

    public void setStatusModulo(String statusModulo) {
        this.statusModulo = statusModulo;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public Double getIndiceRisco() {
        return indiceRisco;
    }

    public void setIndiceRisco(Double indiceRisco) {
        this.indiceRisco = indiceRisco;
    }
}
