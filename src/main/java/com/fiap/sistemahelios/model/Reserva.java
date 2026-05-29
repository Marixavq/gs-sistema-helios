package com.fiap.sistemahelios.model;

import java.time.LocalDate;

public class Reserva {

    private Long idReserva;
    private Usuario usuario;
    private ModuloHabitacional modulo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String statusReserva;
}
