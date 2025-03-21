package com.elite.app.api.controllers;

import com.elite.app.api.entities.Marca;
import com.elite.app.api.models.request.MarcaRequest;
import com.elite.app.api.services.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaService.getAll();
    }

    @GetMapping("/{id}")
    public Marca traerMarca(@PathVariable Integer id) {
        return marcaService.getById(id);
    }

    @PostMapping
    public Marca crearMarca(
             @RequestBody MarcaRequest marcaRequest
    ) {
        return marcaService.save(marcaRequest);
    }

    @PutMapping("/{id}")
    public Marca actualizarMarca(
            @PathVariable Integer id, @RequestBody MarcaRequest marcaRequest
    ) {
        return marcaService.update(id, marcaRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarMarca(@PathVariable Integer id) {
        return marcaService.delete(id);
    }

}
