package br.com.agrosphere.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_medicao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}
