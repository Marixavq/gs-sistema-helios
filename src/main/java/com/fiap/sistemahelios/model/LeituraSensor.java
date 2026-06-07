package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "leitura_sensor")
@Schema(
        name = "Leitura Sensor",
        description = "Representa uma leitura do sensor no sistema Helios"
)
public class LeituraSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único da leitura do sensor",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sensor", nullable = false)
    @NotNull(message = "O sensor é obrigatório")
    @Schema(
            description = "Sensor responsável pela leitura",
            example = "1"
    )
    private Sensor sensor;

    @NotNull(message = "O valor da leitura é obrigatório")
    @Column(name = "valor_leitura", nullable = false)
    @Schema(
            description = "Valor registrado pelo sensor",
            example = "23.5"
    )
    private Double valorLeitura;

    @NotNull(message = "Data e hora da leitura são obrigatórias")
    @Column(name = "data_hora_leitura", nullable = false)
    @Schema(
            description = "Data e hora em que a leitura foi realizada",
            example = "2026-06-07T14:30:00"
    )
    private LocalDateTime dataHoraLeitura;

    @NotBlank(message = "O status da leitura é obrigatório")
    @Size(max = 20, message = "O status da leitura deve ter no máximo 20 caracteres")
    @Column(name = "status_leitura", nullable = false, length = 20)
    @Schema(
            description = "Status da leitura realizada pelo sensor",
            example = "NORMAL"
    )
    private String statusLeitura;

    public LeituraSensor() {
    }

    public LeituraSensor(Sensor sensor, Double valorLeitura, LocalDateTime dataHoraLeitura, String statusLeitura) {
        this.sensor = sensor;
        this.valorLeitura = valorLeitura;
        this.dataHoraLeitura = dataHoraLeitura;
        this.statusLeitura = statusLeitura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getValorLeitura() {
        return valorLeitura;
    }

    public void setValorLeitura(Double valorLeitura) {
        this.valorLeitura = valorLeitura;
    }

    public LocalDateTime getDataHoraLeitura() {
        return dataHoraLeitura;
    }

    public void setDataHoraLeitura(LocalDateTime dataHoraLeitura) {
        this.dataHoraLeitura = dataHoraLeitura;
    }

    public String getStatusLeitura() {
        return statusLeitura;
    }

    public void setStatusLeitura(String statusLeitura) {
        this.statusLeitura = statusLeitura;
    }
}
