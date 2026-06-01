package br.com.agrosphere.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class MedicaoId implements Serializable {

    private Long sensorId;

    private LocalDateTime dataHora;
}
