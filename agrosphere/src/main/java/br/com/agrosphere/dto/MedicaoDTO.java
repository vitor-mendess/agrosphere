package br.com.agrosphere.dto;

import jakarta.validation.constraints.NotNull;

public record MedicaoDTO(

        Long id,

        @NotNull(message = "Valor obrigatório")
        Double valor,

        Long sensorId

) {
}