package com.elite.app.api.controllers;

import com.elite.app.api.entities.Modelo;
import com.elite.app.api.models.request.ModeloRequest;
import com.elite.app.api.services.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zapato/modelo")
@RequiredArgsConstructor
public class ModeloController {
    private final ModeloService modeloService;

    @GetMapping
    public List<Modelo> listarModelos() {
        return modeloService.getAll();
    }

    @GetMapping("/{id}")
    public Modelo traerModelo(@PathVariable Integer id) {
        return modeloService.getById(id);
    }

    @PostMapping
    public Modelo crearModelo(
            @RequestBody ModeloRequest modelo
    ) {
        return modeloService.save(modelo);
    }

    @PutMapping("/{id}")
    public Modelo actualizarModelo(
            @PathVariable Integer id, @RequestBody ModeloRequest modelo
    ) {
        return modeloService.update(id, modelo);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarModelo(@PathVariable Integer id) {
        return modeloService.delete(id);
    }
}
