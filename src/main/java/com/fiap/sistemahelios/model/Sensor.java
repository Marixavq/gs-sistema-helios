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
}
