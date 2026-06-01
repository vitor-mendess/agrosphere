package br.com.agrosphere.repository;

import br.com.agrosphere.entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByMensagemContainingIgnoreCase(String mensagem);
}