package br.com.agrosphere.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "tb_fazenda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String localizacao;

    private Double areaHectares;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "fazenda")
    private List<Sensor> sensores;

    @JsonIgnore
    @OneToMany(mappedBy = "fazenda")
    private List<Alerta> alertas;

}
