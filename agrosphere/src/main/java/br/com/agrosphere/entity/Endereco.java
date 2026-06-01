package br.com.agrosphere.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {

    private String rua;

    private String cidade;

    private String estado;
}