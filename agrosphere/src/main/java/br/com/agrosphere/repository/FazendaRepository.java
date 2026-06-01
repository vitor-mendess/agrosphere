package br.com.agrosphere.repository;

import br.com.agrosphere.entity.Fazenda;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    List<Fazenda> findByNomeContainingIgnoreCase(String nome);


}
