package br.com.agrosphere.exception;

public class FazendaNaoEncontradaException extends RuntimeException {

    public FazendaNaoEncontradaException(Long id) {
        super("Fazenda com ID " + id + " não encontrada");
    }
}