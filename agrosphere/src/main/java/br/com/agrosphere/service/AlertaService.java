package br.com.agrosphere.service;

import br.com.agrosphere.dto.AlertaDTO;
import br.com.agrosphere.entity.Alerta;
import br.com.agrosphere.entity.Fazenda;
import br.com.agrosphere.exception.AlertaNaoEncontradoException;
import br.com.agrosphere.exception.FazendaNaoEncontradaException;
import br.com.agrosphere.repository.AlertaRepository;
import br.com.agrosphere.repository.FazendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaService {

    private final AlertaRepository alertaRepository;
    private final FazendaRepository fazendaRepository;

    public AlertaDTO cadastrar(AlertaDTO dto){

        Fazenda fazenda = fazendaRepository.findById(dto.fazendaId())
                .orElseThrow(() ->
                        new FazendaNaoEncontradaException(dto.fazendaId()));

        Alerta alerta = Alerta.builder()
                .mensagem(dto.mensagem())
                .nivel(dto.nivel())
                .dataHora(LocalDateTime.now())
                .fazenda(fazenda)
                .build();

        alerta = alertaRepository.save(alerta);

        return new AlertaDTO(
                alerta.getId(),
                alerta.getMensagem(),
                alerta.getNivel(),
                fazenda.getId()
        );
    }
    public Page<Alerta> listar(Pageable pageable) {
        return alertaRepository.findAll(pageable);
    }

    public Alerta buscarPorId(Long id) {

        return alertaRepository.findById(id)
                .orElseThrow(() ->
                        new AlertaNaoEncontradoException(id));
    }

    public AlertaDTO atualizar(Long id, AlertaDTO dto) {

        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() ->
                        new AlertaNaoEncontradoException(id));

        Fazenda fazenda = fazendaRepository.findById(dto.fazendaId())
                .orElseThrow(() ->
                        new FazendaNaoEncontradaException(dto.fazendaId()));

        alerta.setMensagem(dto.mensagem());
        alerta.setNivel(dto.nivel());
        alerta.setFazenda(fazenda);

        alerta = alertaRepository.save(alerta);

        return new AlertaDTO(
                alerta.getId(),
                alerta.getMensagem(),
                alerta.getNivel(),
                fazenda.getId()
        );
    }

    public void deletar(Long id) {

        if (!alertaRepository.existsById(id)) {
            throw new AlertaNaoEncontradoException(id);
        }

        alertaRepository.deleteById(id);
    }

    public List<Alerta> buscarPorMensagem(String mensagem) {
        return alertaRepository.findByMensagemContainingIgnoreCase(mensagem);
    }
}
