package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

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
    private Long id;

    @ManyToOne
    private ModuloHabitacional modulo;
    @ManyToOne
    private Sensor sensor;

    private String tipoAlerta;
    private String mensagem;
    private String nivelCriticidade;
    private LocalDateTime dataHoraAlerta;
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
