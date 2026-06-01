package br.com.agrosphere.service;

import br.com.agrosphere.dto.UsuarioDTO;
import br.com.agrosphere.entity.Usuario;
import br.com.agrosphere.exception.UsuarioNaoEncontradoException;
import br.com.agrosphere.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioDTO cadastrar(UsuarioDTO dto){

        Usuario usuario = Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(dto.senha())
                .build();

        usuario = repository.save(usuario);

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new UsuarioNaoEncontradoException(id));
    }

    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new UsuarioNaoEncontradoException(id);
        }

        repository.deleteById(id);
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new UsuarioNaoEncontradoException(id));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        usuario = repository.save(usuario);

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }

    public Page<Usuario> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }


}
