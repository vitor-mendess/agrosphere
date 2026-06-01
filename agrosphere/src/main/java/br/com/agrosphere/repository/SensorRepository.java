package br.com.agrosphere.repository;

import br.com.agrosphere.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByNomeContainingIgnoreCase(String nome);
}