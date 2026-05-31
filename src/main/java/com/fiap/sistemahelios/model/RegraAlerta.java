package com.fiap.sistemahelios.model;

public class RegraAlerta {

    private Long idRegra;
    private String tipoSensor;
    private Double valorMinimo;
    private Double valorMaximo;
    private String nivelCriticidade;
    private String mensagemPadrao;
    private Boolean ativo;

    public RegraAlerta() {
    }

    public RegraAlerta(Long idRegra, String tipoSensor, Double valorMinimo, Double valorMaximo, String nivelCriticidade, String mensagemPadrao, Boolean ativo) {
        this.idRegra = idRegra;
        this.tipoSensor = tipoSensor;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.nivelCriticidade = nivelCriticidade;
        this.mensagemPadrao = mensagemPadrao;
        this.ativo = ativo;
    }

    public Long getIdRegra() {
        return idRegra;
    }

    public void setIdRegra(Long idRegra) {
        this.idRegra = idRegra;
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
