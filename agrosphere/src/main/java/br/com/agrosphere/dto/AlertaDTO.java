package br.com.agrosphere.dto;

public record AlertaDTO(

        Long id,
        String mensagem,
        String nivel,
        Long fazendaId

) {
}
