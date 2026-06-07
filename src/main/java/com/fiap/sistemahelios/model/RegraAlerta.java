package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "regra_alerta")
@Schema(
        name = "Regra Alerta",
        description = "Representa uma regra para ativar um alerta no sistema Helios"
)
public class RegraAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único da regra de alerta",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = "Tipo do sensor é obrigatório")
    @Size(max = 50, message = "O tipo do sensor deve ter no máximo 50 caracteres")
    @Column(name = "tipo_sensor", nullable = false, length = 50)
    @Schema(
            description = "Tipo do sensor associado à regra",
            example = "Temperatura",
            maxLength = 50
    )
    private String tipoSensor;

    @NotNull(message = "Valor mínimo é obrigatório")
    @Column(name = "valor_minimo", nullable = false)
    @Schema(
            description = "Valor mínimo permitido para disparo da regra",
            example = "10.0"
    )
    private Double valorMinimo;

    @NotNull(message = "Valor máximo é obrigatório")
    @Column(name = "valor_maximo", nullable = false)
    @Schema(
            description = "Valor máximo permitido para disparo da regra",
            example = "35.0"
    )
    private Double valorMaximo;

    @NotBlank(message = "Nível de criticidade é obrigatório")
    @Size(max = 30, message = "O nível de criticidade deve ter no máximo 30 caracteres")
    @Column(name = "nivel_criticidade", nullable = false, length = 30)
    @Schema(
            description = "Nível de criticidade da regra",
            example = "ALTO",
            maxLength = 30
    )
    private String nivelCriticidade;

    @NotNull(message = "O peso de risco é obrigatório")
    @Min(value = 1, message = "O peso de risco deve ser no mínimo 1")
    @Max(value = 10, message = "O peso de risco deve ser no máximo 10")
    @Column(name = "peso_risco", nullable = false)
    @Schema(
            description = "Peso utilizado para cálculo e priorização do risco",
            example = "5",
            minimum = "1",
            maximum = "10"
    )
    private Integer pesoRisco;

    @NotBlank(message = "Mensagem padrão é obrigatória")
    @Size(max = 255, message = "A mensagem padrão deve ter no máximo 255 caracteres")
    @Column(name = "mensagem_padrao", nullable = false, length = 255)
    @Schema(
            description = "Mensagem padrão exibida quando a regra é acionada",
            example = "Sensor fora do intervalo permitido",
            maxLength = 255
    )
    private String mensagemPadrao;

    @NotNull(message = "Campo ativo é obrigatório")
    @Column(nullable = false)
    @Schema(
            description = "Indica se a regra está ativa no sistema",
            example = "true"
    )
    private Boolean ativo;

    public RegraAlerta() {
    }

    public RegraAlerta(Long id, String tipoSensor, Double valorMinimo, Double valorMaximo, String nivelCriticidade, Integer pesoRisco, String mensagemPadrao, Boolean ativo) {
        this.id = id;
        this.tipoSensor = tipoSensor;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.nivelCriticidade = nivelCriticidade;
        this.pesoRisco = pesoRisco;
        this.mensagemPadrao = mensagemPadrao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getNivelCriticidade() {
        return nivelCriticidade;
    }

    public void setNivelCriticidade(String nivelCriticidade) {
        this.nivelCriticidade = nivelCriticidade;
    }

    public Integer getPesoRisco() {
        return pesoRisco;
    }

    public void setPesoRisco(Integer pesoRisco) {
        this.pesoRisco = pesoRisco;
    }

    public String getMensagemPadrao() {
        return mensagemPadrao;
    }

    public void setMensagemPadrao(String mensagemPadrao) {
        this.mensagemPadrao = mensagemPadrao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
