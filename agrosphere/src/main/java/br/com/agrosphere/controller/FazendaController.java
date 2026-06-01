package br.com.agrosphere.controller;

import br.com.agrosphere.dto.FazendaDTO;
import br.com.agrosphere.entity.Fazenda;
import br.com.agrosphere.service.FazendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Fazendas",
        description = "Gerenciamento das fazendas cadastradas"
)
@RestController
@RequestMapping("/fazendas")
@RequiredArgsConstructor
public class FazendaController {

    private final FazendaService service;

    @Operation(summary = "Cadastrar fazenda")
    @PostMapping
    public FazendaDTO cadastrar(
            @RequestBody @Valid FazendaDTO dto
    ) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Listar fazendas com paginação")
    @GetMapping
    public Page<Fazenda> listar(
            Pageable pageable
    ) {
        return service.listar(pageable);
    }

    @Operation(summary = "Buscar fazenda por ID")
    @GetMapping("/{id}")
    public Fazenda buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar fazenda")
    @PutMapping("/{id}")
    public FazendaDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid FazendaDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Excluir fazenda")
    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }

    @Operation(summary = "Buscar fazendas por nome")
    @GetMapping("/buscar")
    public List<Fazenda> buscar(
            @RequestParam String nome
    ) {
        return service.buscarPorNome(nome);
    }
}
