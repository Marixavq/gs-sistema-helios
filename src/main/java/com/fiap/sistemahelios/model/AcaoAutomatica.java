package com.fiap.sistemahelios.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AcaoAutomatica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alerta")
    private Alerta alerta;

    private String descricao;

    private LocalDateTime dataHoraExecucao;

    private String statusAcao;

    public AcaoAutomatica() {
    }

    public AcaoAutomatica(Alerta alerta, String descricao, LocalDateTime dataHoraExecucao, String statusAcao) {
        this.alerta = alerta;
        this.descricao = descricao;
        this.dataHoraExecucao = dataHoraExecucao;
        this.statusAcao = statusAcao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraExecucao() {
        return dataHoraExecucao;
    }

    public void setDataHoraExecucao(LocalDateTime dataHoraExecucao) {
        this.dataHoraExecucao = dataHoraExecucao;
    }

    public String getStatusAcao() {
        return statusAcao;
    }

    public void setStatusAcao(String statusAcao) {
        this.statusAcao = statusAcao;
    }
}
