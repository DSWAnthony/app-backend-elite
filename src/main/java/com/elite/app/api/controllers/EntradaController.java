package com.elite.app.api.controllers;


import com.elite.app.api.entities.Entrada;
import com.elite.app.api.models.request.EntradaRequest;
import com.elite.app.api.services.EntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingreso/zapato")
@RequiredArgsConstructor
public class EntradaController {
    private final EntradaService entradaService;

    @GetMapping
    public List<Entrada> listarEntradas() {
        return entradaService.getAll();
    }

    @GetMapping("/{id}")
    public Entrada traerEntrada(@PathVariable Integer id) {
        return entradaService.getById(id);
    }

    @PostMapping
    public Entrada crearEntrada(
            @RequestBody EntradaRequest entrada
    ) {
        return entradaService.save(entrada);
    }

    @PutMapping("/{id}")
    public Entrada actualizarEntrada(
            @PathVariable Integer id, @RequestBody EntradaRequest entrada
    ) {
        return entradaService.update(id, entrada);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarEntrada(@PathVariable Integer id) {
        return entradaService.delete(id);
    }

}
