package br.com.agrosphere.service;

import br.com.agrosphere.dto.SensorDTO;
import br.com.agrosphere.entity.Fazenda;
import br.com.agrosphere.entity.Sensor;
import br.com.agrosphere.exception.FazendaNaoEncontradaException;
import br.com.agrosphere.exception.SensorNaoEncontradoException;
import br.com.agrosphere.repository.FazendaRepository;
import br.com.agrosphere.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final FazendaRepository fazendaRepository;

    public SensorDTO cadastrar(SensorDTO dto){

        Fazenda fazenda = fazendaRepository.findById(dto.fazendaId())
                .orElseThrow(() ->
                        new FazendaNaoEncontradaException(dto.fazendaId()));

        Sensor sensor = Sensor.builder()
                .nome(dto.nome())
                .tipo(dto.tipo())
                .ativo(dto.ativo())
                .fazenda(fazenda)
                .build();

        sensor = sensorRepository.save(sensor);

        return new SensorDTO(
                sensor.getId(),
                sensor.getNome(),
                sensor.getTipo(),
                sensor.getAtivo(),
                fazenda.getId()
        );
    }
    public List<Sensor> listar() {
        return sensorRepository.findAll();
    }

    public Sensor buscarPorId(Long id) {

        return sensorRepository.findById(id)
                .orElseThrow(() ->
                        new SensorNaoEncontradoException(id));
    }

    public SensorDTO atualizar(Long id, SensorDTO dto) {

        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() ->
                        new SensorNaoEncontradoException(id));

        Fazenda fazenda = fazendaRepository.findById(dto.fazendaId())
                .orElseThrow(() ->
                        new FazendaNaoEncontradaException(dto.fazendaId()));

        sensor.setNome(dto.nome());
        sensor.setTipo(dto.tipo());
        sensor.setAtivo(dto.ativo());
        sensor.setFazenda(fazenda);

        sensor = sensorRepository.save(sensor);

        return new SensorDTO(
                sensor.getId(),
                sensor.getNome(),
                sensor.getTipo(),
                sensor.getAtivo(),
                fazenda.getId()
        );
    }

    public void deletar(Long id) {

        if (!sensorRepository.existsById(id)) {
            throw new SensorNaoEncontradoException(id);
        }

        sensorRepository.deleteById(id);
    }

    public Page<Sensor> listar(Pageable pageable) {
        return sensorRepository.findAll(pageable);
    }

    public List<Sensor> buscarPorNome(String nome) {
        return sensorRepository.findByNomeContainingIgnoreCase(nome);
    }
}