package com.elite.app.api.controllers;

import com.elite.app.api.entities.Inventario;
import com.elite.app.api.models.request.InventarioRequest;
import com.elite.app.api.models.response.InventarioResponse;
import com.elite.app.api.services.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {
    private final InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listarInventarios() {
        return inventarioService.getAll();
    }

    @GetMapping("/detalle")
    public List<InventarioResponse> listarDetalleInventario() {
        return inventarioService.listarInventario();
    }

    @GetMapping("/{id}")
    public Inventario traerInventario(@PathVariable Integer id) {
        return inventarioService.getById(id);
    }

    @PostMapping
    public Inventario crearInventario(
            @RequestBody InventarioRequest inventario
    ) {
        return inventarioService.save(inventario);
    }

    @PutMapping("/{id}")
    public Inventario actualizarInventario(
            @PathVariable Integer id, @RequestBody InventarioRequest inventario
    ) {
        return inventarioService.update(id, inventario);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarInventario(@PathVariable Integer id) {
        return inventarioService.delete(id);
    }

}
