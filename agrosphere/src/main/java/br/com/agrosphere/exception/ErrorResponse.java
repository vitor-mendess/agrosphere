package br.com.agrosphere.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        String mensagem,
        int status,
        LocalDateTime timestamp
) {
}
