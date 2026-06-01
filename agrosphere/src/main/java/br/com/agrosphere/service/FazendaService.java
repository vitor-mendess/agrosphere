package br.com.agrosphere.service;

import br.com.agrosphere.dto.FazendaDTO;
import br.com.agrosphere.entity.Fazenda;
import br.com.agrosphere.entity.Usuario;
import br.com.agrosphere.exception.FazendaNaoEncontradaException;
import br.com.agrosphere.exception.UsuarioNaoEncontradoException;
import br.com.agrosphere.repository.FazendaRepository;
import br.com.agrosphere.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FazendaService {

    private final FazendaRepository fazendaRepository;
    private final UsuarioRepository usuarioRepository;

    public FazendaDTO cadastrar(FazendaDTO dto){

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() ->
                        new UsuarioNaoEncontradoException(dto.usuarioId()));

        Fazenda fazenda = Fazenda.builder()
                .nome(dto.nome())
                .localizacao(dto.localizacao())
                .areaHectares(dto.areaHectares())
                .usuario(usuario)
                .build();

        fazenda = fazendaRepository.save(fazenda);

        return new FazendaDTO(
                fazenda.getId(),
                fazenda.getNome(),
                fazenda.getLocalizacao(),
                fazenda.getAreaHectares(),
                usuario.getId()
        );
    }

    public List<Fazenda> listar() {
        return fazendaRepository.findAll();
    }

    public Fazenda buscarPorId(Long id) {

        return fazendaRepository.findById(id)
                .orElseThrow(() ->
                        new FazendaNaoEncontradaException(id));
    }

    public FazendaDTO atualizar(Long id, FazendaDTO dto) {

        Fazenda fazenda = fazendaRepository.findById(id)
                .orElseThrow(() ->
                        new FazendaNaoEncontradaException(id));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() ->
                        new UsuarioNaoEncontradoException(dto.usuarioId()));

        fazenda.setNome(dto.nome());
        fazenda.setLocalizacao(dto.localizacao());
        fazenda.setAreaHectares(dto.areaHectares());
        fazenda.setUsuario(usuario);

        fazenda = fazendaRepository.save(fazenda);

        return new FazendaDTO(
                fazenda.getId(),
                fazenda.getNome(),
                fazenda.getLocalizacao(),
                fazenda.getAreaHectares(),
                usuario.getId()
        );
    }

    public void deletar(Long id) {

        if (!fazendaRepository.existsById(id)) {
            throw new FazendaNaoEncontradaException(id);
        }

        fazendaRepository.deleteById(id);
    }

    public Page<Fazenda> listar(Pageable pageable) {
        return fazendaRepository.findAll(pageable);
    }

    public List<Fazenda> buscarPorNome(String nome) {
        return fazendaRepository.findByNomeContainingIgnoreCase(nome);
    }
}
