package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class LogEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único do log de evento",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @NotBlank(message = "O tipo do evento é obrigatório")
    @Size(max = 50, message = "O tipo do evento deve ter no máximo 50 caracteres")
    @Column(name = "tipo_evento", nullable = false, length = 50)
    @Schema(
            description = "Tipo do evento registrado",
            example = "ALERTA",
            maxLength = 50
    )
    private String tipoEvento;

    @NotBlank(message = "A descrição do evento é obrigatória")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    @Column(name = "descricao", nullable = false, length = 255)
    @Schema(
            description = "Descrição detalhada do evento",
            example = "Sensor de temperatura registrou valor acima do limite",
            maxLength = 255
    )
    private String descricao;

    @NotNull(message = "A data e hora do evento são obrigatórias")
    @Column(name = "data_hora_evento", nullable = false)
    @Schema(
            description = "Data e hora em que o evento ocorreu",
            example = "2026-06-07T14:45:00"
    )
    private LocalDateTime dataHoraEvento;

    @NotBlank(message = "A origem do evento é obrigatória")
    @Size(max = 100, message = "A origem do evento deve ter no máximo 100 caracteres")
    @Column(name = "origem_evento", nullable = false, length = 100)
    @Schema(
            description = "Origem responsável pela geração do evento",
            example = "Sensor de Temperatura do Módulo Aurora",
            maxLength = 100
    )
    private String origemEvento;

    @NotBlank(message = "O nível do evento é obrigatório")
    @Size(max = 30, message = "O nível do evento deve ter no máximo 20 caracteres")
    @Column(name = "nivel_evento", nullable = false, length = 30)
    @Schema(
            description = "Nível de severidade do evento",
            example = "ALTO",
            maxLength = 30
    )
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
