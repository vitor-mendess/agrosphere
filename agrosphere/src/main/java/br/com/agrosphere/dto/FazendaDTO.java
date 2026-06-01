package br.com.agrosphere.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record FazendaDTO(

        Long id,

        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotBlank(message = "Localização obrigatória")
        String localizacao,

        @Positive(message = "Área deve ser positiva")
        Double areaHectares,

        Long usuarioId

) {
}