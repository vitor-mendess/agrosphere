package br.com.agrosphere.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> tratarUsuarioNaoEncontrado(
            UsuarioNaoEncontradoException ex
    ) {

        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
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

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(SensorNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> tratarSensorNaoEncontrado(
            SensorNaoEncontradoException ex
    ) {

        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MedicaoNaoEncontradaException.class)
    public ResponseEntity<ErrorResponse> tratarMedicaoNaoEncontrada(
            MedicaoNaoEncontradaException ex
    ) {

        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(erro);
    }

    @ExceptionHandler(AlertaNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> tratarAlertaNaoEncontrado(
            AlertaNaoEncontradoException ex
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