package com.fiap.sistemahelios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LogEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoEvento;
    private String descricao;
    private LocalDateTime dataHoraEvento;
    private String origemEvento;
    private String nivelEvento;

    public LogEvento() {
    }

    public LogEvento(String tipoEvento, String descricao, LocalDateTime dataHoraEvento, String origemEvento, String nivelEvento) {
        this.tipoEvento = tipoEvento;
        this.descricao = descricao;
        this.dataHoraEvento = dataHoraEvento;
        this.origemEvento = origemEvento;
        this.nivelEvento = nivelEvento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraEvento() {
        return dataHoraEvento;
    }

    public void setDataHoraEvento(LocalDateTime dataHoraEvento) {
        this.dataHoraEvento = dataHoraEvento;
    }

    public String getOrigemEvento() {
        return origemEvento;
    }

    public void setOrigemEvento(String origemEvento) {
        this.origemEvento = origemEvento;
    }

    public String getNivelEvento() {
        return nivelEvento;
    }

    public void setNivelEvento(String nivelEvento) {
        this.nivelEvento = nivelEvento;
    }
}
