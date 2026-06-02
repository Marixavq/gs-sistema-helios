package com.fiap.sistemahelios.exception;

public class SensorNaoEncontradoException extends RuntimeException {
    public SensorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
