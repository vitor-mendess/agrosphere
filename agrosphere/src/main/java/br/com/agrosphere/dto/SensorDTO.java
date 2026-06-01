package br.com.agrosphere.dto;

import br.com.agrosphere.entity.TipoSensor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SensorDTO(

        Long id,

        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotNull(message = "Tipo obrigatório")
        TipoSensor tipo,

        Boolean ativo,

        Long fazendaId

) {
}
