package br.com.agrosphere.controller;

import br.com.agrosphere.dto.MedicaoDTO;
import br.com.agrosphere.entity.Medicao;
import br.com.agrosphere.service.MedicaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Medições",
        description = "Gerenciamento das medições realizadas pelos sensores"
)
@RestController
@RequestMapping("/medicoes")
@RequiredArgsConstructor
public class MedicaoController {

    private final MedicaoService service;

    @Operation(summary = "Cadastrar medição")
    @PostMapping
    public MedicaoDTO cadastrar(
            @RequestBody @Valid MedicaoDTO dto
    ) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Listar medições com paginação")
    @GetMapping
    public Page<Medicao> listar(
            Pageable pageable
    ) {
        return service.listar(pageable);
    }

    @Operation(summary = "Buscar medição por ID")
    @GetMapping("/{id}")
    public Medicao buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar medição")
    @PutMapping("/{id}")
    public MedicaoDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid MedicaoDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Excluir medição")
    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }

    @Operation(summary = "Buscar medições por valor mínimo")
    @GetMapping("/buscar")
    public List<Medicao> buscar(
            @RequestParam Double valor
    ) {
        return service.buscarValorAcima(valor);
    }
}