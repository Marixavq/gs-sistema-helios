package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "regra_alerta")
@Schema(
        name = "Regra Alerta",
        description = "Representa uma regra para ativar um alerta no sistema Helios"
)
public class RegraAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoSensor;
    private Double valorMinimo;
    private Double valorMaximo;
    private String nivelCriticidade;
    private String mensagemPadrao;
    private Boolean ativo;

    public RegraAlerta() {
    }

    public RegraAlerta(String tipoSensor, Double valorMinimo, Double valorMaximo, String nivelCriticidade, String mensagemPadrao, Boolean ativo) {
        this.tipoSensor = tipoSensor;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.nivelCriticidade = nivelCriticidade;
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
