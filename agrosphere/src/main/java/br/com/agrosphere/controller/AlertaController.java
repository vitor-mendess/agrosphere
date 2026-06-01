package br.com.agrosphere.controller;

import br.com.agrosphere.dto.AlertaDTO;
import br.com.agrosphere.entity.Alerta;
import br.com.agrosphere.service.AlertaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Alertas",
        description = "Gerenciamento dos alertas gerados pelo sistema"
)
@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaController {

    private final AlertaService service;

    @Operation(summary = "Cadastrar alerta")
    @PostMapping
    public AlertaDTO cadastrar(
            @RequestBody @Valid AlertaDTO dto
    ) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Listar alertas com paginação")
    @GetMapping
    public Page<Alerta> listar(
            Pageable pageable
    ) {
        return service.listar(pageable);
    }

    @Operation(summary = "Buscar alerta por ID")
    @GetMapping("/{id}")
    public Alerta buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar alerta")
    @PutMapping("/{id}")
    public AlertaDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid AlertaDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Excluir alerta")
    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }

    @Operation(summary = "Buscar alertas por mensagem")
    @GetMapping("/buscar")
    public List<Alerta> buscar(
            @RequestParam String mensagem
    ) {
        return service.buscarPorMensagem(mensagem);
    }
}
