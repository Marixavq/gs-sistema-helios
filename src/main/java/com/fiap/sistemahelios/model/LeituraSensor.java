package com.fiap.sistemahelios.model;

import java.time.LocalDateTime;

public class LeituraSensor {

    private Long id;
    private Sensor sensor;
    private Double valorLeitura;
    private LocalDateTime dataHoraLeitura;
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
