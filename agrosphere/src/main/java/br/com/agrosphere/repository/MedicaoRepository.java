package br.com.agrosphere.repository;

import br.com.agrosphere.entity.Medicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {
    List<Medicao> findByValorGreaterThan(Double valor);
}
