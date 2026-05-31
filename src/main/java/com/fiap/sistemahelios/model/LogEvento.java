package com.fiap.sistemahelios.model;

import java.time.LocalDateTime;

public class LogEvento {

    private Long idLog;
    private String tipoEvento;
    private String descricao;
    private LocalDateTime dataHoraEvento;
    private String origemEvento;
    private String nivelEvento;

    public LogEvento() {
    }

    public LogEvento(Long idLog, String tipoEvento, String descricao, LocalDateTime dataHoraEvento, String origemEvento, String nivelEvento) {
        this.idLog = idLog;
        this.tipoEvento = tipoEvento;
        this.descricao = descricao;
        this.dataHoraEvento = dataHoraEvento;
        this.origemEvento = origemEvento;
        this.nivelEvento = nivelEvento;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
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
