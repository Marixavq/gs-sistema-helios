package com.fiap.sistemahelios.model;

import java.time.LocalDate;

public class Sensor {

    private Long idSensor;
    private ModuloHabitacional modulo;
    private String nomeSensor;
    private String tipoSensor;
    private String statusSensor;
    private String unidadeMedida;
    private Double limiteMinimo;
    private Double limiteMaximo;
    private LocalDate dataInstalacao;

    public Sensor() {
    }

    public Sensor(Long idSensor, ModuloHabitacional modulo, String nomeSensor, String tipoSensor, String statusSensor, String unidadeMedida, Double limiteMinimo, Double limiteMaximo, LocalDate dataInstalacao) {
        this.idSensor = idSensor;
        this.modulo = modulo;
        this.nomeSensor = nomeSensor;
        this.tipoSensor = tipoSensor;
        this.statusSensor = statusSensor;
        this.unidadeMedida = unidadeMedida;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
        this.dataInstalacao = dataInstalacao;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public ModuloHabitacional getModulo() {
        return modulo;
    }

    public void setModulo(ModuloHabitacional modulo) {
        this.modulo = modulo;
    }

    public String getNomeSensor() {
        return nomeSensor;
    }

    public void setNomeSensor(String nomeSensor) {
        this.nomeSensor = nomeSensor;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public String getStatusSensor() {
        return statusSensor;
    }

    public void setStatusSensor(String statusSensor) {
        this.statusSensor = statusSensor;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getLimiteMinimo() {
        return limiteMinimo;
    }

    public void setLimiteMinimo(Double limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    public Double getLimiteMaximo() {
        return limiteMaximo;
    }

    public void setLimiteMaximo(Double limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }
}
