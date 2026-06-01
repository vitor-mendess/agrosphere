package br.com.agrosphere.exception;

public class SensorNaoEncontradoException extends RuntimeException {

    public SensorNaoEncontradoException(Long id) {
        super("Sensor com ID " + id + " não encontrado");
    }
}