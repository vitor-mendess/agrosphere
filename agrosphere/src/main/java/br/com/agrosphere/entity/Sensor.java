package br.com.agrosphere.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "tb_sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoSensor tipo;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda;

    @JsonIgnore
    @OneToMany(mappedBy = "sensor")
    private List<Medicao> medicoes;
}