package br.com.agrosphere.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_alerta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private String nivel;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda;
}
