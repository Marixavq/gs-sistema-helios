package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerta")
@Schema(
        name = "Alerta",
        description = "Representa um alerta no sistema Helios"
)
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único do alerta",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    @NotNull(message = "O módulo é obrigatório")
    @Schema(
            description = "Módulo habitacional associado ao alerta",
            example = "1"
    )
    private ModuloHabitacional modulo;

    @ManyToOne
    @JoinColumn(name = "id_sensor", nullable = false)
    @NotNull(message = "O sensor é obrigatório")
    @Schema(
            description = "Sensor que gerou o alerta",
            example = "1"
    )
    private Sensor sensor;

    @NotBlank(message = "Tipo de alerta é obrigatório")
    @Size(max = 50, message = "O tipo de alerta deve ter no máximo 50 caracteres")
    @Column(name = "tipo_alerta", nullable = false, length = 50)
    @Schema(
            description = "Tipo do alerta gerado pelo sistema",
            example = "TEMPERATURA_ALTA",
            maxLength = 50
    )
    private String tipoAlerta;

    @NotBlank(message = "Mensagem é obrigatória")
    @Size(max = 255, message = "A mensagem deve ter no máximo 255 caracteres")
    @Column(name = "mensagem", nullable = false, length = 255)
    @Schema(
            description = "Mensagem descritiva do alerta",
            example = "Temperatura acima do limite permitido",
            maxLength = 255
    )
    private String mensagem;

    @NotBlank(message = "Nível de criticidade é obrigatório")
    @Size(max = 30, message = "O nível de criticidade deve ter no máximo 30 caracteres")
    @Column(name = "nivel_criticidade", nullable = false, length = 30)
    @Schema(
            description = "Nível de criticidade do alerta",
            example = "ALTO",
            maxLength = 30
    )
    private String nivelCriticidade;

    @NotNull(message = "Data e hora do alerta é obrigatória")
    @Column(name = "data_hora_alerta", nullable = false)
    @Schema(
            description = "Data e hora em que o alerta foi gerado",
            example = "2026-06-07T14:30:00"
    )
    private LocalDateTime dataHoraAlerta;

    @NotBlank(message = "Status do alerta é obrigatório")
    @Size(max = 30, message = "O status do alerta deve ter no máximo 30 caracteres")
    @Column(name = "status_alerta", nullable = false, length = 30)
    @Schema(
            description = "Status atual do alerta",
            example = "ABERTO",
            maxLength = 30
    )
    private String statusAlerta;

    public Alerta() {
    }

    public Alerta(ModuloHabitacional modulo, Sensor sensor, String tipoAlerta, String mensagem, String nivelCriticidade, LocalDateTime dataHoraAlerta, String statusAlerta) {
        this.modulo = modulo;
        this.sensor = sensor;
        this.tipoAlerta = tipoAlerta;
        this.mensagem = mensagem;
        this.nivelCriticidade = nivelCriticidade;
        this.dataHoraAlerta = dataHoraAlerta;
        this.statusAlerta = statusAlerta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModuloHabitacional getModulo() {
        return modulo;
    }

    public void setModulo(ModuloHabitacional modulo) {
        this.modulo = modulo;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNivelCriticidade() {
        return nivelCriticidade;
    }

    public void setNivelCriticidade(String nivelCriticidade) {
        this.nivelCriticidade = nivelCriticidade;
    }

    public LocalDateTime getDataHoraAlerta() {
        return dataHoraAlerta;
    }

    public void setDataHoraAlerta(LocalDateTime dataHoraAlerta) {
        this.dataHoraAlerta = dataHoraAlerta;
    }

    public String getStatusAlerta() {
        return statusAlerta;
    }

    public void setStatusAlerta(String statusAlerta) {
        this.statusAlerta = statusAlerta;
    }
}
