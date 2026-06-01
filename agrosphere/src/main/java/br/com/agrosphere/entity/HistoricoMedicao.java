package br.com.agrosphere.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HistoricoMedicao {

    @EmbeddedId
    private MedicaoId id;

    private Double valor;
}