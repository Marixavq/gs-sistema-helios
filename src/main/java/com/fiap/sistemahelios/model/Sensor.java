package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "sensor")
@Schema(
        name = "Sensor",
        description = "Representa um sensor no sistema Helios"
)
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único do sensor",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    @NotNull(message = "O módulo é obrigatório")
    @Schema(
            description = "Módulo habitacional ao qual o sensor está vinculado",
            example = "1"
    )
    private ModuloHabitacional modulo;

    @NotBlank(message = "Nome do sensor é obrigatório")
    @Size(max = 100, message = "O nome do sensor deve ter no máximo 100 caracteres")
    @Column(name = "nome_sensor", nullable = false, length = 100)
    @Schema(
            description = "Nome do sensor",
            example = "Sensor de Temperatura Interna",
            maxLength = 100
    )
    private String nomeSensor;

    @NotBlank(message = "Tipo do sensor é obrigatório")
    @Size(max = 50, message = "O tipo do sensor deve ter no máximo 50 caracteres")
    @Column(name = "tipo_sensor", nullable = false, length = 50)
    @Schema(
            description = "Tipo do sensor (temperatura, umidade, pressão etc.)",
            example = "Temperatura",
            maxLength = 50
    )
    private String tipoSensor;

    @NotBlank(message = "Status do sensor é obrigatório")
    @Size(max = 30, message = "O status do sensor deve ter no máximo 30 caracteres")
    @Column(name = "status_sensor", nullable = false, length = 30)
    @Schema(
            description = "Status atual do sensor",
            example = "ATIVO",
            maxLength = 30
    )
    private String statusSensor;

    @NotBlank(message = "Unidade de medida é obrigatória")
    @Size(max = 20, message = "A unidade de medida deve ter no máximo 20 caracteres")
    @Column(name = "unidade_medida", nullable = false, length = 20)
    @Schema(
            description = "Unidade de medida do sensor",
            example = "°C",
            maxLength = 20
    )
    private String unidadeMedida;

    @Column(name = "limite_minimo")
    @Schema(
            description = "Valor mínimo aceitável do sensor",
            example = "10.5"
    )
    private Double limiteMinimo;

    @Column(name = "limite_maximo")
    @Schema(
            description = "Valor máximo aceitável do sensor",
            example = "35.0"
    )
    private Double limiteMaximo;

    @NotNull(message = "Intervalo de leitura é obrigatório")
    @Positive(message = "O intervalo deve ser maior que zero")
    @Column(name = "intervalo_leitura_segundos", nullable = false)
    @Schema(
            description = "Intervalo de leitura do sensor em segundos",
            example = "60"
    )
    private Integer intervaloLeituraSegundos;

    @NotNull(message = "Data de instalação é obrigatória")
    @Column(name = "data_instalacao", nullable = false, updatable = false)
    @Schema(
            description = "Data de instalação do sensor",
            example = "2026-01-10",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDate dataInstalacao;

    public Sensor() {
    }

    public Sensor(ModuloHabitacional modulo, String nomeSensor, String tipoSensor, String statusSensor, String unidadeMedida, Double limiteMinimo, Double limiteMaximo, Integer intervaloLeituraSegundos) {
        this.modulo = modulo;
        this.nomeSensor = nomeSensor;
        this.tipoSensor = tipoSensor;
        this.statusSensor = statusSensor;
        this.unidadeMedida = unidadeMedida;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
        this.intervaloLeituraSegundos = intervaloLeituraSegundos;
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

    public Integer getIntervaloLeituraSegundos() {
        return intervaloLeituraSegundos;
    }

    public void setIntervaloLeituraSegundos(Integer intervaloLeituraSegundos) {
        this.intervaloLeituraSegundos = intervaloLeituraSegundos;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    @PrePersist
    protected void onCreate() {
        this.dataInstalacao = LocalDate.now();
    }
}
