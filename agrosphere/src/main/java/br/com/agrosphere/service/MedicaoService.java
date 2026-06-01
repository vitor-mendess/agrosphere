package br.com.agrosphere.service;

import br.com.agrosphere.dto.MedicaoDTO;
import br.com.agrosphere.entity.Medicao;
import br.com.agrosphere.entity.Sensor;
import br.com.agrosphere.exception.MedicaoNaoEncontradaException;
import br.com.agrosphere.exception.SensorNaoEncontradoException;
import br.com.agrosphere.repository.MedicaoRepository;
import br.com.agrosphere.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicaoService {

    private final MedicaoRepository medicaoRepository;
    private final SensorRepository sensorRepository;

    public MedicaoDTO cadastrar(MedicaoDTO dto){

        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() ->
                        new SensorNaoEncontradoException(dto.sensorId()));

        Medicao medicao = Medicao.builder()
                .valor(dto.valor())
                .dataHora(LocalDateTime.now())
                .sensor(sensor)
                .build();

        medicao = medicaoRepository.save(medicao);

        return new MedicaoDTO(
                medicao.getId(),
                medicao.getValor(),
                sensor.getId()
        );
    }

    public Page<Medicao> listar(Pageable pageable) {
        return medicaoRepository.findAll(pageable);
    }

    public Medicao buscarPorId(Long id) {

        return medicaoRepository.findById(id)
                .orElseThrow(() ->
                        new MedicaoNaoEncontradaException(id));
    }

    public MedicaoDTO atualizar(Long id, MedicaoDTO dto) {

        Medicao medicao = medicaoRepository.findById(id)
                .orElseThrow(() ->
                        new MedicaoNaoEncontradaException(id));

        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() ->
                        new SensorNaoEncontradoException(dto.sensorId()));

        medicao.setValor(dto.valor());
        medicao.setSensor(sensor);

        medicao = medicaoRepository.save(medicao);

        return new MedicaoDTO(
                medicao.getId(),
                medicao.getValor(),
                sensor.getId()
        );
    }

    public void deletar(Long id) {

        if (!medicaoRepository.existsById(id)) {
            throw new MedicaoNaoEncontradaException(id);
        }

        medicaoRepository.deleteById(id);
    }

    public List<Medicao> buscarValorAcima(Double valor) {
        return medicaoRepository.findByValorGreaterThan(valor);
    }
}