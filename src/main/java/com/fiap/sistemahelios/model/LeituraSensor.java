package com.fiap.sistemahelios.model;

import java.time.LocalDateTime;

public class LeituraSensor {

    private Long idLeitura;
    private Sensor sensor;
    private Double valorLeitura;
    private LocalDateTime dataHoraLeitura;
    private String statusLeitura;

    public LeituraSensor() {
    }

    public LeituraSensor(Long idLeitura, Sensor sensor, Double valorLeitura, LocalDateTime dataHoraLeitura, String statusLeitura) {
        this.idLeitura = idLeitura;
        this.sensor = sensor;
        this.valorLeitura = valorLeitura;
        this.dataHoraLeitura = dataHoraLeitura;
        this.statusLeitura = statusLeitura;
    }

    public Long getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Long idLeitura) {
        this.idLeitura = idLeitura;
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
