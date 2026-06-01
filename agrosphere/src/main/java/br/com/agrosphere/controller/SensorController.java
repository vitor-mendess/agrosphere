package br.com.agrosphere.controller;

import br.com.agrosphere.dto.SensorDTO;
import br.com.agrosphere.entity.Sensor;
import br.com.agrosphere.service.SensorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Sensores",
        description = "Gerenciamento dos sensores das fazendas"
)
@RestController
@RequestMapping("/sensores")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService service;

    @Operation(summary = "Cadastrar sensor")
    @PostMapping
    public SensorDTO cadastrar(
            @RequestBody @Valid SensorDTO dto
    ) {
        return service.cadastrar(dto);
    }

    @Operation(summary = "Listar sensores com paginação")
    @GetMapping
    public Page<Sensor> listar(
            Pageable pageable
    ) {
        return service.listar(pageable);
    }

    @Operation(summary = "Buscar sensor por ID")
    @GetMapping("/{id}")
    public Sensor buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar sensor")
    @PutMapping("/{id}")
    public SensorDTO atualizar(
            @PathVariable Long id,
            @RequestBody @Valid SensorDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Excluir sensor")
    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }

    @Operation(summary = "Buscar sensores por nome")
    @GetMapping("/buscar")
    public List<Sensor> buscar(
            @RequestParam String nome
    ) {
        return service.buscarPorNome(nome);
    }
}