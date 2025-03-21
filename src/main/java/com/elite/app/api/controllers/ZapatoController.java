package com.elite.app.api.controllers;

import com.elite.app.api.entities.Zapato;
import com.elite.app.api.models.request.ZapatoRequest;
import com.elite.app.api.services.ZapatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zapato")
@RequiredArgsConstructor
public class ZapatoController {
    private final ZapatoService zapatoService;

    @GetMapping
    public List<Zapato> listarZapatos() {
        return zapatoService.getAll();
    }

    @GetMapping("/{id}")
    public Zapato traerZapato(@PathVariable Integer id) {
        return zapatoService.getById(id);
    }

    @PostMapping
    public Zapato crearZapato(
            @RequestBody ZapatoRequest zapatoRequest
    ) {
        return zapatoService.save(zapatoRequest);
    }

    @PutMapping("/{id}")
    public Zapato actualizarZapato(
            @PathVariable Integer id, @RequestBody ZapatoRequest zapatoRequest
    ) {
        return zapatoService.update(id, zapatoRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarZapato(@PathVariable Integer id) {
        return zapatoService.delete(id);
    }
}
