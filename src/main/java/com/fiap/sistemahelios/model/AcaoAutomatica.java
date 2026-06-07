package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class AcaoAutomatica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único da ação automática",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alerta", nullable = false)
    @NotNull(message = "O alerta é obrigatório")
    @Schema(
            description = "Alerta que originou a ação automática",
            example = "1"
    )
    private Alerta alerta;

    @NotBlank(message = "A descrição da ação é obrigatória")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    @Column(name = "descricao", nullable = false, length = 255)
    @Schema(
            description = "Descrição da ação automática executada",
            example = "Redução automática da temperatura do módulo",
            maxLength = 255
    )
    private String descricao;

    @NotNull(message = "A data e hora de execução são obrigatórias")
    @Column(name = "data_hora_execucao", nullable = false)
    @Schema(
            description = "Data e hora em que a ação automática foi executada",
            example = "2026-06-07T14:35:00"
    )
    private LocalDateTime dataHoraExecucao;

    @NotBlank(message = "O status da ação é obrigatório")
    @Size(max = 30, message = "O status da ação deve ter no máximo 30 caracteres")
    @Column(name = "status_acao", nullable = false, length = 30)
    @Schema(
            description = "Status atual da ação automática",
            example = "EXECUTADA",
            maxLength = 30
    )
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
