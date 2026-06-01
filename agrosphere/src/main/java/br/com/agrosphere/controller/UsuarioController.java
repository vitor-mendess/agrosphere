package br.com.agrosphere.controller;

import br.com.agrosphere.dto.UsuarioDTO;
import br.com.agrosphere.entity.Usuario;
import br.com.agrosphere.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;



import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Usuários",
        description = "Gerenciamento de usuários do sistema"
)
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @Operation(summary = "Cadastrar usuário")
    @PostMapping
    public UsuarioDTO cadastrar(
            @RequestBody @Valid UsuarioDTO dto
    ) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Listar usuários com paginação")
    @GetMapping
    public Page<Usuario> listar(
            Pageable pageable
    ) {
        return service.listar(pageable);
    }

    @Operation(summary = "Buscar usuário por ID")
    @GetMapping("/{id}")
    public Usuario buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar usuário")
    @PutMapping("/{id}")
    public UsuarioDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid UsuarioDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Excluir usuário")
    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }

    @Operation(summary = "Buscar usuário por nome")
    @GetMapping("/buscar")
    public List<Usuario> buscar(
            @RequestParam String nome
    ) {
        return service.buscarPorNome(nome);
    }
}
