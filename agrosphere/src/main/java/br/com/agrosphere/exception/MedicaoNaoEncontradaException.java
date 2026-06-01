package br.com.agrosphere.exception;

public class MedicaoNaoEncontradaException extends RuntimeException {

    public MedicaoNaoEncontradaException(Long id) {
        super("Medição com ID " + id + " não encontrada");
    }
}
