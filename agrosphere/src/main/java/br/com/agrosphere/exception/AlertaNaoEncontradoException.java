package br.com.agrosphere.exception;

public class AlertaNaoEncontradoException extends RuntimeException {

    public AlertaNaoEncontradoException(Long id) {
        super("Alerta com ID " + id + " não encontrado");
    }
}
