package com.fiap.sistemahelios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "ocupantes")
@Schema(
        name = "Ocupante",
        description = "Representa um ocupante no sistema Helios"
)
public class Ocupante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ocupante")
    private Long id;

    private String nome;

    private String funcao;

    @Column(name = "status_ocupante")
    private String statusOcupante;

    @Column(name = "data_registro")
    private LocalDate dataRegistro;


    public Ocupante() {
    }

    public Ocupante(String nome, String funcao, String statusOcupante) {
        this.nome = nome;
        this.funcao = funcao;
        this.statusOcupante = statusOcupante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getStatusOcupante() {
        return statusOcupante;
    }

    public void setStatusOcupante(String statusOcupante) {
        this.statusOcupante = statusOcupante;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}

