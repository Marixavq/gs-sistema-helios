package com.fiap.sistemahelios.model;

public class ModuloHabitacional {

    private Long idModulo;
    private Habitat habitat;
    private String nomeModulo;
    private String tipoModulo;
    private Integer capacidadeOcupantes;
    private String statusModulo;
    private String nivelRisco;
    private Double consumoEnergia;
    private Double consumoAgua;

    public ModuloHabitacional() {
    }

    public ModuloHabitacional(Long idModulo, Habitat habitat, String nomeModulo, String tipoModulo, Integer capacidadeOcupantes, String statusModulo, String nivelRisco, Double consumoEnergia, Double consumoAgua) {
        this.idModulo = idModulo;
        this.habitat = habitat;
        this.nomeModulo = nomeModulo;
        this.tipoModulo = tipoModulo;
        this.capacidadeOcupantes = capacidadeOcupantes;
        this.statusModulo = statusModulo;
        this.nivelRisco = nivelRisco;
        this.consumoEnergia = consumoEnergia;
        this.consumoAgua = consumoAgua;
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public String getTipoModulo() {
        return tipoModulo;
    }

    public void setTipoModulo(String tipoModulo) {
        this.tipoModulo = tipoModulo;
    }

    public Integer getCapacidadeOcupantes() {
        return capacidadeOcupantes;
    }

    public void setCapacidadeOcupantes(Integer capacidadeOcupantes) {
        this.capacidadeOcupantes = capacidadeOcupantes;
    }

    public String getStatusModulo() {
        return statusModulo;
    }

    public void setStatusModulo(String statusModulo) {
        this.statusModulo = statusModulo;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }

    public Double getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(Double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public Double getConsumoAgua() {
        return consumoAgua;
    }

    public void setConsumoAgua(Double consumoAgua) {
        this.consumoAgua = consumoAgua;
    }
}
