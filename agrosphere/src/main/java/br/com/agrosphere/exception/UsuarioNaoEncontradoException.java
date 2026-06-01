package br.com.agrosphere.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(Long id) {
        super("Usuário com ID " + id + " não encontrado");
    }

    @ExceptionHandler(FazendaNaoEncontradaException.class)
    public ResponseEntity<ErrorResponse> tratarFazendaNaoEncontrada(
            FazendaNaoEncontradaException ex
    ) {

        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(erro);
    }
}