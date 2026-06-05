package com.fiap.sistemahelios.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "modulos_habitacionais")
@Schema(
        name = "Modulo Habitacional",
        description = "Representa um modulo habitacional no sistema Helios"
)
public class ModuloHabitacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Habitat é obrigatório")
    @ManyToOne
    @JoinColumn(name = "habitat_id", nullable = false)
    private Habitat habitat;

    @NotBlank(message = "Nome do módulo é obrigatório")
    @Size(min = 3, max = 100, message = "O nome do módulo deve ter entre 3 e 100 caracteres")
    @Column(name = "nome_modulo", nullable = false, length = 100)
    private String nomeModulo;

    @NotBlank(message = "Tipo do módulo é obrigatório")
    @Size(min = 3, max = 50, message = "O tipo do módulo deve ter entre 3 e 50 caracteres")
    @Column(name = "tipo_modulo", nullable = false, length = 50)
    private String tipoModulo;

    @NotNull(message = "Capacidade de ocupantes é obrigatória")
    @Positive(message = "A capacidade deve ser maior que zero")
    @Column(name = "capacidade_ocupantes", nullable = false)
    private Integer capacidadeOcupantes;

    private Integer capacidadeAtual;

    @NotBlank(message = "Status do módulo é obrigatório")
    @Size(max = 20, message = "O status do módulo deve ter no máximo 20 caracteres")
    @Column(name = "status_modulo", nullable = false, length = 20)
    private String statusModulo;

    @NotBlank(message = "Nível de risco é obrigatório")
    @Size(max = 20, message = "O nível de risco deve ter no máximo 20 caracteres")
    @Column(name = "nivel_risco", nullable = false, length = 20)
    private String nivelRisco;

    private String indiceRisco;


    public ModuloHabitacional() {
    }

    public ModuloHabitacional(Habitat habitat, String nomeModulo, String tipoModulo, Integer capacidadeOcupantes, Integer capacidadeAtual, String statusModulo, String nivelRisco, String indiceRisco) {
        this.habitat = habitat;
        this.nomeModulo = nomeModulo;
        this.tipoModulo = tipoModulo;
        this.capacidadeOcupantes = capacidadeOcupantes;
        this.capacidadeAtual = capacidadeAtual;
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

    public Integer getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public void setCapacidadeAtual(Integer capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
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

    public String getIndiceRisco() {
        return indiceRisco;
    }

    public void setIndiceRisco(String indiceRisco) {
        this.indiceRisco = indiceRisco;
    }
}
