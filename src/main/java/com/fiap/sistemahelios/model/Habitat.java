package com.fiap.sistemahelios.model;

import java.time.LocalDate;

public class Habitat {
    private Long idHabitat;
    private String nome;
    private String localizacao;
    private String tipoHabitat;
    private Integer capacidadeTotal;
    private String statusOperacional;
    private LocalDate dataCriacao;

    public Habitat() {
    }

    public Habitat(Long idHabitat, String nome, String localizacao, String tipoHabitat, Integer capacidadeTotal, String statusOperacional, LocalDate dataCriacao) {
        this.idHabitat = idHabitat;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoHabitat = tipoHabitat;
        this.capacidadeTotal = capacidadeTotal;
        this.statusOperacional = statusOperacional;
        this.dataCriacao = dataCriacao;
    }

    public Long getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(Long idHabitat) {
        this.idHabitat = idHabitat;
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
}
