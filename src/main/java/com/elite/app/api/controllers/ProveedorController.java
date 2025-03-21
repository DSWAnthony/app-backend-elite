package com.elite.app.api.controllers;

import com.elite.app.api.entities.Proveedor;
import com.elite.app.api.models.request.ProveedorRequest;
import com.elite.app.api.services.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedor")
@RequiredArgsConstructor
public class ProveedorController {
    private final ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> listarProveedors() {
        return proveedorService.getAll();
    }

    @GetMapping("/{id}")
    public Proveedor traerProveedor(@PathVariable Integer id) {
        return proveedorService.getById(id);
    }

    @PostMapping
    public Proveedor crearProveedor(
            @RequestBody ProveedorRequest proveedor
    ) {
        return proveedorService.save(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor actualizarProveedor(
            @PathVariable Integer id, @RequestBody ProveedorRequest proveedor
    ) {
        return proveedorService.update(id, proveedor);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarProveedor(@PathVariable Integer id) {
        return proveedorService.delete(id);
    }
}
